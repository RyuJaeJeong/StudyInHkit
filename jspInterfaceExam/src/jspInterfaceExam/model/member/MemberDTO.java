package jspInterfaceExam.model.member;

public class MemberDTO {
//field

private String id;
private String pwd;
private String nme;
private String phone;
private String job;

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

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public String getNme() {
	return nme;
}

public void setNme(String nme) {
	this.nme = nme;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}



	
}
