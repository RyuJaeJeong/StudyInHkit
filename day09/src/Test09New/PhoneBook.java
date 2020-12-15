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
		System.out.println("이름?");
		name = sc.nextLine();
		System.out.println("번호?");
		num = sc.nextLine();
		System.out.println("지역?");
		loc = sc.nextLine();
	}
	//Method
	public void display () {
		System.out.println(name +"    "+num+"    "+loc);
	}
	
}
