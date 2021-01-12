package test_loop.dto;

import java.sql.Timestamp;

public class transactionDTO {

	private int no;
	private String name;
	private Timestamp wdate;
	
	//cons
	public transactionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	//g&s toString
	
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

	public Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "transactionDTO [no=" + no + ", name=" + name + ", wdate=" + wdate + "]";
	}
	
	
	
	
}
