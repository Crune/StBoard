package board.action;

import board.core.ArticleSupport;
import board.vo.BoardVO;

public class CheckAction extends ArticleSupport {

	private static final long serialVersionUID = -2373475383476798801L;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {

		// 현재 글의 비밀번호 가져오기.
		BoardVO rst = (BoardVO) sqlMap.queryForObject("selectPassword", model);
		
		// 입력한 비밀번호가 틀리면 ERROR 리턴.
		if (rst == null) return ERROR;

		// 패스워드 체크 성공한 글번호 세션에 저장		
		sMap.put("passOkNo", rst.getNo());
		log.info("passOk No. "+rst.getNo());

		return SUCCESS;
	}

}
