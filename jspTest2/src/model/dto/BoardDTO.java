package model.dto;

import java.util.Date;

public class BoardDTO {
	
	//field
	private int no;
	private String writer;
	private String subject;
	private String content;
	private Date regiDate;
	private String passwd;
	
	//cons
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	//method


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegiDate() {
		return regiDate;
	}


	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
}
