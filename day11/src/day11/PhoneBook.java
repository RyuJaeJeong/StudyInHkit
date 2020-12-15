package day11;

public class PhoneBook {
	

	//객체모델링

	
	
	//field - 이름, 전화번호
	private String name;
	private String phoneNo;
	
	//constructor   : 객체를 생성할 때 초기화 시켜주는 역활
	
	public PhoneBook() {
		// TODO Auto-generated constructor stub
	}
	
	public PhoneBook(String name, String phoneNo ) {
		this.name = name;
		this.phoneNo = phoneNo;// TODO Auto-generated constructor stub
	}
	
	
	
	
	//method
	public void display() {
		System.out.println(name + " / " + phoneNo);
	}
	
	
	//getter&setter
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name =name;
	}
	
	

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public static void main(String[] args) {
		
		//항상 궁극적인 것은 필드에 값 집어넣는거임.
		
		PhoneBook phoneBook1 = new PhoneBook(); 
		
		
		phoneBook1.setName("홍길동");
		phoneBook1.setPhoneNo("01056578990");
		String no = phoneBook1.getPhoneNo();
		
		
		
		
		
		PhoneBook phoneBook2 = new PhoneBook();
		phoneBook2.setName("이지윤");
		phoneBook2.setPhoneNo("01027283435");
		phoneBook2.display();
		
		
		PhoneBook phoneBook3 = new PhoneBook();
		phoneBook3.setName("장천용");
		phoneBook3.setPhoneNo("01012345678");
		phoneBook3.display();
		
		PhoneBook phoneBook4 = new PhoneBook("이상대", "01044444444");
		phoneBook4.display();
		
		PhoneBook phoneBook5 = new PhoneBook("박정훈", "01094331960");
		phoneBook5.display();
		
		//생성자 오버로딩, 메소드 오버로딩.
		
		
		
	}

}
