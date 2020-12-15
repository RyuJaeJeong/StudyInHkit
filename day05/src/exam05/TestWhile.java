package exam05;

import java.util.Scanner;

public class TestWhile {

	public static void main(String[] args) {
//		int i = 1;
//		while (true) {
//			System.out.println(i++);
//			if (i>10) break;
//		}
//		System.out.println("프로그램 종료");
	
	Scanner sc = new Scanner(System.in);
	
//	
//	while (true) {
//		System.out.print("몇단을 원하세요?");
//		int qqt1 = sc.nextInt();
//		int f =1;
//		String y = "y";
//		while(f<=9) {
//			System.out.println(qqt1+"*"+f+" = "+qqt1*f++);
//		} System.out.println("계속하시려면 y를 눌러주세요.");
//		  String qqt2 =sc.next();
//		  if(qqt2.toUpperCase().equals("Y")){
//			  continue;
//	
//		  }
//	}	  
	String qqt2 = "y";
	do {
		System.out.print("몇단을 원하세요?");
		int qqt1 = sc.nextInt();
		int f =1;
		String y = "y";
		System.out.println("====="+qqt1+"단"+"=====");
		while(f<=9) {
		   
			System.out.println(qqt1+"*"+f+" = "+qqt1*f++);
		} System.out.println("계속하시려면 y를 눌러주세요.");
		   qqt2 =sc.next();
		} while(qqt2.toLowerCase().equals("y"));
		  
	System.out.println("프로그램 종료");
	
	
	
	
	
	
	
	
	
	
	
	

	}

}
	