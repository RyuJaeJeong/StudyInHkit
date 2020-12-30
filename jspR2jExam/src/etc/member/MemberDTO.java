package etc.member;

import java.sql.Timestamp;

public class MemberDTO {

	
//field
	private int no;
	private String id;
	private String passwd;
	private String passwdCheck;
	private String name;
	private String sid1;
	private String sid2;
	private String nickname;
	private String phone;
	private String gender;
	private String age;
	private String grade;
	private Timestamp wdate; //date, time stamp
	private int loginFailCounter;
	private String ip;	

//cons 
	public MemberDTO() {
		
	}
	

//getter&setter	

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

	public String getPasswdCheck() {
		return passwdCheck;
	}

	public void setPasswdCheck(String passwdCheck) {
		this.passwdCheck = passwdCheck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSid1() {
		return sid1;
	}

	public void setSid1(String sid1) {
		this.sid1 = sid1;
	}

	public String getSid2() {
		return sid2;
	}

	public void setSid2(String sid2) {
		this.sid2 = sid2;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

	public int getLoginFailCounter() {
		return loginFailCounter;
	}

	public void setLoginFailCounter(int loginFailCounter) {
		this.loginFailCounter = loginFailCounter;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	

	
	
	
}
