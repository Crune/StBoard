package board.core;

import java.io.File;
import java.util.Calendar;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import board.vo.BoardVO;

@SuppressWarnings("serial")
public abstract class ArticleSupport extends IbatisActionSupport implements Preparable, ModelDriven<BoardVO> {

	protected BoardVO model;
	
	protected String fileUploadPath = "f:\\save\\";

	protected Calendar today = Calendar.getInstance(); //오늘 날짜 구하기.
	
	private File upload; //파일 객체
	public File getUpload() { return upload; }
	public void setUpload(File upload) { this.upload = upload; }

	private String uploadContentType; //컨텐츠 타입
	public String getUploadContentType() { return uploadContentType; }
	public void setUploadContentType(String uploadContentType) { this.uploadContentType = uploadContentType; }

	private String uploadFileName; //파일 이름
	public String getUploadFileName() { return uploadFileName; }
	public void setUploadFileName(String uploadFileName) { this.uploadFileName = uploadFileName; }


	@Override
	public abstract String execute() throws Exception;

	@Override
	public BoardVO getModel() { return this.model; }

	@Override
	public void prepare() throws Exception { this.model = new BoardVO(); }

}
