package exam03;

import java.util.Scanner;

public class TestCalSwitch {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 피연산자를 입력하세요 : ");
		int first = sc.nextInt();
		sc.nextLine();
		System.out.print("연산 부호를 입력하세요 (+-*/) : ");
		String second = sc.nextLine();
		sc.nextLine();
		System.out.print("두번째 피연산자를 입력하세요 : ");
		int third = sc.nextInt();
		sc.nextLine();
		
		int ans;
		double result;
		
		switch(second) {
		case "+" :
			ans = first + third;
		case "-" :
			ans = first - third;
		case "*" :
			ans = first*third; 
		case "/"  : 
			result = (double)first/third;
		default :
			System.out.println("연산부호를 잘못 입력하셨습니다.");
			
			
			
		}
		
		
	}
	

}
