package board.core;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import board.vo.BoardVO;

@SuppressWarnings("serial")
public abstract class ArticleSupport extends IbatisActionSupport implements Preparable, ModelDriven<BoardVO> {

	protected BoardVO model;

	@Override
	public abstract String execute() throws Exception;

	@Override
	public BoardVO getModel() { return this.model; }

	@Override
	public void prepare() throws Exception { this.model = new BoardVO(); }

}
