package com.test.spring01.test.member.model.dto;

import java.util.Date;

public class MemberDTO {
	
	
	//field
	private String id;
	private String passwd;
	private String name;
	private String email;
	private Date regi_date;
	
	//cons
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	//getter&setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegi_date() {
		return regi_date;
	}

	public void setRegi_date(Date regi_date) {
		this.regi_date = regi_date;
	}
	
	
}
