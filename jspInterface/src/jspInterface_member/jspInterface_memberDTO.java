package jspInterface_member;

import java.sql.Date;
import java.sql.Timestamp;

public class jspInterface_memberDTO {

//field
private int no;
private String id;
private String passwd;
private String nme;
private String sid;
private String phone;
private String email;
private String gender;
private String age;
private Timestamp wdate;

//cons
public jspInterface_memberDTO() {
	// TODO Auto-generated constructor stub
}

//method
public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}

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

public String getNme() {
	return nme;
}

public void setNme(String nme) {
	this.nme = nme;
}

public String getSid() {
	return sid;
}

public void setSid(String sid) {
	this.sid = sid;
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

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public Timestamp getWdate() {
	return wdate;
}

public void setWdate(Timestamp wdate) {
	this.wdate = wdate;
}






}
