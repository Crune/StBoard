package board.action;

import java.util.List;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import board.core.IbatisActionSupport;
import board.vo.BoardVO;
import board.vo.Paging;

public class ListAction
	extends IbatisActionSupport
	implements Preparable, ModelDriven<Paging> {

	private static final long serialVersionUID = 5290847131490975688L;

	private static final int blockCount = 10; // 한 페이지의  게시물의 수
	private static final int blockPage = 5; // 한 화면에 보여줄 페이지 수

	private Paging page; // 페이징 클래스

	@Override
	public void prepare() throws Exception {
		page = new Paging(blockCount, blockPage); // pagingAction 객체 생성.
	}

	@Override
	public Paging getModel() {
		return this.page;
	}

	private List<BoardVO> list;
	public List<BoardVO> getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// 현재 페이지를 세션에 저장한다.
		sMap.put("currentPage", page.getCurrentPage());
		
		// 모든 글을 가져와 list에 넣는다.
		list = sqlMap.queryForList("selectAll");

		int totalCount = list.size(); // 전체 글 갯수를 구한다.
		page.init(totalCount);

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount) lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		list = list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}
}
