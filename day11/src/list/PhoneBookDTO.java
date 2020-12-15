package list;

public class PhoneBookDTO {
	//Field -----------------------------------------------
	private String name;
	private String pNo;
	private int age;
	
	
	
	//constructor-----------------------------------------
	public PhoneBookDTO() {
		
	}

	
	public PhoneBookDTO(String name, String pNo, int age) {
		this.name = name;
		this.pNo = pNo;
		this.age = age;
		
	}
	
	
	//Method
	
	public void display() {
		System.out.println(name + " / " + age + " / " + pNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Getter&Setter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
