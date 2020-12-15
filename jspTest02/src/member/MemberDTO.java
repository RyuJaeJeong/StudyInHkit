package member;

public class MemberDTO {

	//field
	private String id;
	private String pass;
	private String passcheck;
	private String nme;
	private String phone;
	private String email;
	private String birthYear;
	
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPasscheck() {
		return passcheck;
	}

	public void setPasscheck(String passcheck) {
		this.passcheck = passcheck;
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
