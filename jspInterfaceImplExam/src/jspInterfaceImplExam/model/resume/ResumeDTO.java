package jspInterfaceImplExam.model.resume;

import java.io.File;

public class ResumeDTO {
//field
 int no;	
private String upload_path;
private String pic_name;
private String name;
private String email;
private String phone;
private String address;
private String TOEIC;
private String TOEFL;
private String japan;
private String china;

private String gigan1;
private String school1;
private String jeongong1;

private String gigan2;
private String school2;
private String jeongong2;

private String gigan3;
private String school3;
private String jeongong3;

private String gigan4;
private String school4;
private String jeongong4;

//cons

public ResumeDTO() {
	// TODO Auto-generated constructor stub
}


//getter&setter


public String getName() {
	return name;
}

public String getUpload_path() {
	return upload_path;
}


public void setUpload_path(String upload_path) {
	this.upload_path = upload_path;
}


public String getPic_name() {
	return pic_name;
}


public void setPic_name(String pic_name) {
	this.pic_name = pic_name;
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

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getTOEIC() {
	return TOEIC;
}

public void setTOEIC(String tOEIC) {
	TOEIC = tOEIC;
}

public String getTOEFL() {
	return TOEFL;
}

public void setTOEFL(String tOEFL) {
	TOEFL = tOEFL;
}

public String getJapan() {
	return japan;
}

public void setJapan(String japan) {
	this.japan = japan;
}

public String getChina() {
	return china;
}

public void setChina(String china) {
	this.china = china;
}

public String getGigan1() {
	return gigan1;
}

public void setGigan1(String gigan1) {
	this.gigan1 = gigan1;
}

public String getSchool1() {
	return school1;
}

public void setSchool1(String school1) {
	this.school1 = school1;
}

public String getJeongong1() {
	return jeongong1;
}

public void setJeongong1(String jeongong1) {
	this.jeongong1 = jeongong1;
}

public String getGigan2() {
	return gigan2;
}

public void setGigan2(String gigan2) {
	this.gigan2 = gigan2;
}

public String getSchool2() {
	return school2;
}

public void setSchool2(String school2) {
	this.school2 = school2;
}

public String getJeongong2() {
	return jeongong2;
}

public void setJeongong2(String jeongong2) {
	this.jeongong2 = jeongong2;
}

public String getGigan3() {
	return gigan3;
}

public void setGigan3(String gigan3) {
	this.gigan3 = gigan3;
}

public String getSchool3() {
	return school3;
}

public void setSchool3(String school3) {
	this.school3 = school3;
}

public String getJeongong3() {
	return jeongong3;
}

public void setJeongong3(String jeongong3) {
	this.jeongong3 = jeongong3;
}


public String getGigan4() {
	return gigan4;
}


public void setGigan4(String gigan4) {
	this.gigan4 = gigan4;
}


public String getSchool4() {
	return school4;
}


public void setSchool4(String school4) {
	this.school4 = school4;
}


public String getJeongong4() {
	return jeongong4;
}


public void setJeongong4(String jeongong4) {
	this.jeongong4 = jeongong4;
}


public int getNo() {
	return no;
}


public void setNo(int no) {
	this.no = no;
}


@Override
public String toString() {
	return "ResumeDTO [no=" + no + ", upload_path=" + upload_path + ", pic_name=" + pic_name + ", name=" + name
			+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", TOEIC=" + TOEIC + ", TOEFL=" + TOEFL
			+ ", japan=" + japan + ", china=" + china + ", gigan1=" + gigan1 + ", school1=" + school1 + ", jeongong1="
			+ jeongong1 + ", gigan2=" + gigan2 + ", school2=" + school2 + ", jeongong2=" + jeongong2 + ", gigan3="
			+ gigan3 + ", school3=" + school3 + ", jeongong3=" + jeongong3 + ", gigan4=" + gigan4 + ", school4="
			+ school4 + ", jeongong4=" + jeongong4 + "]";
}






}
