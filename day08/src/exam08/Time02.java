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
		 * �޼ҵ� Ÿ��
		 * 
		 * static void method1() (
		 * )	�ް�x ��ȯx
		 * 
		 * static void method2(int a int b)(
		 * ) 	�ް� �� ��ȯ x
		 * 
		 * static int  method3() (
		 * ) 	�ް� x ��ȯ ��
		 * 
		 * static  int method 4 (int a int b) (
		 * return;
		 * ) 	�ް� �� ��ȯ ��
		 * 
		 * ������ ������ �� ����� ������ ��´�. 
		 * ������ ���� ������ �ϳ��� ������ �� �ִ�. 
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
