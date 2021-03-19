package memo.model.dto;

public class MemoDTO {

	//field 
	int id;
	String name;
	String content;
	String wdate;
	
	//cons
	public MemoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getter&setter
	

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
