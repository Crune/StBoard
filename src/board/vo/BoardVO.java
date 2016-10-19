package board.vo;

import java.util.Date;

public class BoardVO {

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", subject=" + subject + ", name=" + name + ", password=" + password + ", content="
				+ content + ", file_orgname=" + file_orgname + ", file_savname=" + file_savname + ", readhit=" + readhit
				+ ", regdate=" + regdate + "]";
	}

	private int no;
	private String subject;
	private String name;
	private String password;
	private String content;
	private String file_orgname;
	private String file_savname;
	private int readhit;
	private Date regdate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadhit() {
		return readhit;
	}

	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getFile_orgname() {
		return file_orgname;
	}

	public void setFile_orgname(String file_orgname) {
		this.file_orgname = file_orgname;
	}

	public String getFile_savname() {
		return file_savname;
	}

	public void setFile_savname(String file_savname) {
		this.file_savname = file_savname;
	}

	public void modify(BoardVO n) {
		no = n.getNo();
		subject = n.getSubject();
		name = n.getName();
		password = n.getPassword();
		content = n.getContent();
		file_orgname = n.getFile_orgname();
		file_savname = n.getFile_savname();
		readhit = n.getReadhit();
		regdate = n.getRegdate();
	}

}