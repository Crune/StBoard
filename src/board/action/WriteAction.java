package board.action;

import java.io.File;
import org.apache.commons.io.FileUtils;

import board.core.ArticleSupport;
import board.vo.BoardVO;

public class WriteAction extends ArticleSupport {

	private static final long serialVersionUID = -1986675197250953981L;

	@Override
	public String execute() throws Exception {

		// 등록할 항목 설정.
		model.setRegdate(today.getTime());

		// 등록 쿼리 수행.
		sqlMap.insert("insertBoard", model);

		// 첨부파일을 선택했다면 파일을 업로드한다.
		if (getUpload() != null) {

			//등록한 글 번호 가져오기.
			BoardVO result = (BoardVO) sqlMap.queryForObject("selectLastNo");

			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + result.getNo();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length());

			//서버에 파일 저장.
			File destFile = new File(fileUploadPath + file_name + "."
					+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);

			//파일 정보 파라미터 설정.
			model.setNo(result.getNo());
			model.setFile_orgname(getUploadFileName());		//원래 파일 이름
			model.setFile_savname(file_name + "." + file_ext);	//서버에 저장한 파일 이름

			//파일 정보 업데이트.
			sqlMap.update("updateFile", model);
		}

		return SUCCESS;
	}

}
