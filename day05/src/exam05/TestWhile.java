package exam05;

import java.util.Scanner;

public class TestWhile {

	public static void main(String[] args) {
//		int i = 1;
//		while (true) {
//			System.out.println(i++);
//			if (i>10) break;
//		}
//		System.out.println("���α׷� ����");
	
	Scanner sc = new Scanner(System.in);
	
//	
//	while (true) {
//		System.out.print("����� ���ϼ���?");
//		int qqt1 = sc.nextInt();
//		int f =1;
//		String y = "y";
//		while(f<=9) {
//			System.out.println(qqt1+"*"+f+" = "+qqt1*f++);
//		} System.out.println("����Ͻ÷��� y�� �����ּ���.");
//		  String qqt2 =sc.next();
//		  if(qqt2.toUpperCase().equals("Y")){
//			  continue;
//	
//		  }
//	}	  
	String qqt2 = "y";
	do {
		System.out.print("����� ���ϼ���?");
		int qqt1 = sc.nextInt();
		int f =1;
		String y = "y";
		System.out.println("====="+qqt1+"��"+"=====");
		while(f<=9) {
		   
			System.out.println(qqt1+"*"+f+" = "+qqt1*f++);
		} System.out.println("����Ͻ÷��� y�� �����ּ���.");
		   qqt2 =sc.next();
		} while(qqt2.toLowerCase().equals("y"));
		  
	System.out.println("���α׷� ����");
	
	
	
	
	
	
	
	
	
	
	
	

	}

}
	