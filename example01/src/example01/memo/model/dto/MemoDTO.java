package example01.memo.model.dto;

import java.sql.Timestamp;

public class MemoDTO {

	//field
	private int id;
	private String name;
	private String content;
	private Timestamp wdate;
	
	//cons
	public MemoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	//g&s
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}
	
	
	
	
	
}
