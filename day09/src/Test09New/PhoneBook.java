package Test09New;

import java.util.Scanner;

public class PhoneBook {
	//Field
	String name;
	String num;
	String loc;
	//constructor
	public PhoneBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸�?");
		name = sc.nextLine();
		System.out.println("��ȣ?");
		num = sc.nextLine();
		System.out.println("����?");
		loc = sc.nextLine();
	}
	//Method
	public void display () {
		System.out.println(name +"    "+num+"    "+loc);
	}
	
}
