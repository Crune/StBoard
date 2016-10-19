package board.action;

import java.io.File;
import org.apache.commons.io.FileUtils;

import board.core.ArticleSupport;
import board.vo.BoardVO;

public class ModifyAction extends ArticleSupport {

	private static final long serialVersionUID = 5354365462655573845L;

	private String old_file;
	public String getOld_file() { return old_file; }
	public void setOld_file(String old_file) { this.old_file = old_file; }
	
	@Override
	public String execute() throws Exception {

		int sessionNo = (int) sMap.get("passOkNo");
		if (sessionNo != model.getNo()) return ERROR;
		
		// 일단 항목만 수정한다.
		sqlMap.update("updateBoard", model);

		// 수정할 파일이 업로드 되었다면 파일을 업로드하고 DB의 file 항목을 수정함.
		if (getUpload() != null) {
			
			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + model.getNo();
		           String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			//이전 파일 삭제
			File deleteFile = new File(fileUploadPath + getOld_file());
			deleteFile.delete();
			
			//새 파일 업로드
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정.
			model.setFile_orgname(getUploadFileName());
			model.setFile_savname(file_name + "." + file_ext);
			
			//파일 정보 업데이트.
			sqlMap.update("updateFile", model);
		}

		// 수정이 끝나면 view 페이지로 이동.
		BoardVO result = (BoardVO) sqlMap.queryForObject("selectOne", model.getNo());
		inject(result, model);

		return SUCCESS;
	}

}
