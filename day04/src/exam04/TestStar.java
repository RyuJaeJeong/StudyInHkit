package exam04;

import java.util.Scanner;

public class TestStar {

	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
		System.out.print("별의 갯수는 몇개인가요? ");
	 	int num = sc.nextInt();
	 	
//	 	String temp = "";
//	 	for(int i=1; i<=num; i++) {
//	 		 temp += "*";
//	 		 System.out.println(temp);
//	 	}
//
//	 	
	 	for(int i=num; i>=1; i--) {
	 		for (int j=1; j<=i; j++) {
	 			System.out.print("*");
	 		}
	 			System.out.println();
	 	}
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	}

}
