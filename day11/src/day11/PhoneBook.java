package day11;

public class PhoneBook {
	

	//��ü�𵨸�

	
	
	//field - �̸�, ��ȭ��ȣ
	private String name;
	private String phoneNo;
	
	//constructor   : ��ü�� ������ �� �ʱ�ȭ �����ִ� ��Ȱ
	
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
		
		//�׻� �ñ����� ���� �ʵ忡 �� ����ִ°���.
		
		PhoneBook phoneBook1 = new PhoneBook(); 
		
		
		phoneBook1.setName("ȫ�浿");
		phoneBook1.setPhoneNo("01056578990");
		String no = phoneBook1.getPhoneNo();
		
		
		
		
		
		PhoneBook phoneBook2 = new PhoneBook();
		phoneBook2.setName("������");
		phoneBook2.setPhoneNo("01027283435");
		phoneBook2.display();
		
		
		PhoneBook phoneBook3 = new PhoneBook();
		phoneBook3.setName("��õ��");
		phoneBook3.setPhoneNo("01012345678");
		phoneBook3.display();
		
		PhoneBook phoneBook4 = new PhoneBook("�̻��", "01044444444");
		phoneBook4.display();
		
		PhoneBook phoneBook5 = new PhoneBook("������", "01094331960");
		phoneBook5.display();
		
		//������ �����ε�, �޼ҵ� �����ε�.
		
		
		
	}

}
