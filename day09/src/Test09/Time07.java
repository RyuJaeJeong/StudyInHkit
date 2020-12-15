package Test09;

import java.util.Scanner;

public class Time07 {


	
	public Time07() {
		// TODO Auto-generated constructor stub
	}


	void drink(int a) {
		if(a>=20) {
			System.out.println("술을 마실수 있습니다.");
		}else {System.out.println("술을 마실수 없습니다.");
		}
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 살이니? : ");
		int a = sc.nextInt();
		Time07 t1 = new Time07();
		t1.drink(a);
		
		
	
	
	
	
	}

}
