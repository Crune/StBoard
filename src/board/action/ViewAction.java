package board.action;

import board.core.ArticleSupport;
import board.vo.BoardVO;

public class ViewAction extends ArticleSupport {

	private static final long serialVersionUID = -683215532569796524L;

	@Override
	public String execute() throws Exception {

		// 해당 글의 조회수 +1.
		sqlMap.update("updateReadHit", model);

		// 해당 번호의 글을 가져온다.
		BoardVO selected = (BoardVO) sqlMap.queryForObject("selectOne", model.getNo());

		// model의 setter를 호출하여 selected안의 데이터를 주입
		inject(selected, model);

		return SUCCESS;
	}
}
