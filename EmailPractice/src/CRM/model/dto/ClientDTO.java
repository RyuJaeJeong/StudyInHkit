package CRM.model.dto;

public class ClientDTO {

	//field
	private int no;
	private String name;
	private String bornYear;
	private String email;
	
	//cons
	public ClientDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getter & setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBornYear() {
		return bornYear;
	}

	public void setBornYear(String bornYear) {
		this.bornYear = bornYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
