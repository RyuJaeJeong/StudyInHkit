package model.memo.dto;

public class MemoDTO {

	//field 
	String no;
	String name;
	String content;
	String wdate;
	
	//cons
	public MemoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getter&setter
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
	
}
