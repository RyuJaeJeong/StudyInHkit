package Test009;

import java.util.Scanner;

public class PhoneBook {
	
	//field
	String name;
	String number;
	String loc;
	
	//constructor : OverLoding
	
	public PhoneBook() {
		Scanner sc  =new Scanner(System.in);
		System.out.println("�̸�?");
		name = sc.nextLine();
		System.out.println("��ȣ?");
		number = sc.nextLine();
		System.out.println("����?");
		loc = sc.nextLine();
	}
	
	
	//method
	
	public void display () {
		System.out.println(name + "���� ��ȭ��ȣ�� " + number + "�̸�" + " �ְ������� " + loc + "�Դϴ�." );
	}
}
