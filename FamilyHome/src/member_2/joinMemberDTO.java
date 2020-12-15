package member_2;

public class joinMemberDTO {

	
//field
private String no;	
private String id;
private String password; 
private String nme;
private String phone;
private String email;
private String birthYear;

//cons
public joinMemberDTO() {
	// TODO Auto-generated constructor stub
}

//getter&setter 	

public String getId() {
	return id;
}

public String getNo() {
	return no;
}

public void setNo(String no) {
	this.no = no;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String passwd) {
	this.password = passwd;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getBirthYear() {
	return birthYear;
}

public void setBirthYear(String birthYear) {
	this.birthYear = birthYear;
}



}
