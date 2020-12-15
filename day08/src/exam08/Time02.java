package exam08;

import java.util.Scanner;

public class Time02 {
	
	
	static String sum3() {
		int num1 = 5;
		int num2 = 9;
		int hab = num1 + num2;
		String imsi = num1 + "|" + num2 + "|" + hab; //5|9|14
		return imsi;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		/*
		 * 메소드 타입
		 * 
		 * static void method1() (
		 * )	메게x 반환x
		 * 
		 * static void method2(int a int b)(
		 * ) 	메게 ㅇ 반환 x
		 * 
		 * static int  method3() (
		 * ) 	메게 x 반환 ㅇ
		 * 
		 * static  int method 4 (int a int b) (
		 * return;
		 * ) 	메게 ㅇ 반환 ㅇ
		 * 
		 * 리턴이 있으면 그 결과를 변수에 담는다. 
		 * 리턴은 값을 무조건 하나만 내보낼 수 있다. 
		 * 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in); 
		String result3 = sum3(); //5|9|14
		String[] result3_ = result3.split("[|]");
		int a = Integer.parseInt(result3_[0]);
		int b = Integer.parseInt(result3_[1]);
		int hab = Integer.parseInt(result3_[2]);
		
		
		
	}
}
