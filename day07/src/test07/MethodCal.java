package test07;

import java.util.Scanner;

public class MethodCal {
	static void calculator(int first, String operator, int second) {
		if (operator.equals("+")) {
			System.out.println(first+second);
		} else if (operator.equals("-")) {
			System.out.println(first-second);
		} else if (operator.equals("*")) {
			System.out.println(first*second);
		} else   { 
			System.out.println(first/second);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int first = 0;
		int second = 0;
		String operator = "";
		
		
		while(true) {
			System.out.print("첫번째 피연산자를 입력하세요 ");
			first = sc.nextInt();
			if(first==0) break;
			sc.nextLine();
			System.out.print("연산기호를 입력하세요. ");
			operator = sc.nextLine();
			if(operator!="+"||operator!="-"||operator!="*"||operator!="/") continue;
			System.out.print("두번째 피연산자를 입력하세요 ");
			second = sc.nextInt();
			calculator(first,operator,second);
			
		}
		

	}

}
