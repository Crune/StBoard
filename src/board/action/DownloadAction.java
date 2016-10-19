package board.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import board.core.ArticleSupport;
import board.vo.BoardVO;

public class DownloadAction extends ArticleSupport {
	
	private static final long serialVersionUID = 6587380549441554763L;

	private InputStream inputStream;
	public InputStream getInputStream() { return inputStream; }
	private String contentDisposition;
	public String getContentDisposition() { return contentDisposition; }
	private long contentLength;
	public long getContentLength() { return contentLength; }

	@Override
	public String execute() throws Exception {
		// 해당 번호의 파일 정보를 가져온다.
		model = (BoardVO) sqlMap.queryForObject("selectOne", model.getNo());

		// 파일 경로와 파일명을 file 객체에 넣는다.
		File fileInfo = new File(fileUploadPath + model.getFile_savname());

		// 다운로드 파일 정보 설정.
		contentLength =fileInfo.length();
		contentDisposition = "attachment;filename=";
		contentDisposition += URLEncoder.encode(model.getFile_orgname(), "UTF-8");
		inputStream = new FileInputStream(fileUploadPath + model.getFile_savname());

		return SUCCESS;
	}

}
