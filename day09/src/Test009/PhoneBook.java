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
		System.out.println("이름?");
		name = sc.nextLine();
		System.out.println("번호?");
		number = sc.nextLine();
		System.out.println("지역?");
		loc = sc.nextLine();
	}
	
	
	//method
	
	public void display () {
		System.out.println(name + "님의 전화번호는 " + number + "이며" + " 주거지역은 " + loc + "입니다." );
	}
}
