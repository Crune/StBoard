package board.action;

import java.io.File;

import board.vo.BoardVO;
import board.core.ArticleSupport;

public class DeleteAction extends ArticleSupport {
	
	private static final long serialVersionUID = -1630051999861138835L;

	@Override
	public String execute() throws Exception {
		int sessionNo = (int) sMap.get("passOkNo");
		if (sessionNo != model.getNo()) return ERROR;
		
		// 해당 번호의 글을 가져온다.
		BoardVO result = (BoardVO) sqlMap.queryForObject("selectOne", model.getNo());

		//서버 파일 삭제
		File deleteFile = new File(fileUploadPath + result.getFile_savname());
		deleteFile.delete();
				
		// 삭제 쿼리 수행.
		sqlMap.update("deleteBoard", model);

		return SUCCESS;
	}

}
