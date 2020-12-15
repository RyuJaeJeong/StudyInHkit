 package exam08;

import java.util.Scanner;



public class Time01 {
	static void sum(int first, int second) {
		int third = first + second;
		System.out.println("두 수의 합은 "+ third + "입니다.");
	}
	
	static int sum02(int first, int second) {
		int third = first + second;
		return third;
		//반환형, 결과를 돌려줄 자료형. 리턴이란, 호출 해주는 쪽으로 돌려주는것.
	}
	public static void main(String[] args) {
		//메소드는 클래스 안에 존재하지만, 메소드 안에 또다른 메소드가 존재 할 수는 없다. 
		//static void insa(String name) {
		  	//static void insa(0 ) {
		  	//}
		  //}          이렇게는 안된다고.
		//두 수를 입력 받아서 합을 구합니다. 
	Scanner sc = new Scanner(System.in);
	System.out.println("첫번째 숫자 워우 워어~ ");
	int first = sc.nextInt();
	System.out.println("두번째 숫자 워우 워어~ ");
	int second = sc.nextInt();
	
	//sum(first,second);
	
	
	
	
	
	
	//리턴(return)
	int result = sum02(first, second);
	System.out.println(result);
			
	
	
	
	
	
	
	
	
	
	}
}
