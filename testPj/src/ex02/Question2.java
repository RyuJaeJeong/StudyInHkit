package ex02;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
	
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1���� �Է��� �������� ���� ���ص帳�ϴ�! ");
		int num = sc.nextInt();
		long temp = 0;				//1���� n������ ���� �����ϴ� �ӽú���, int Ÿ������ ���� �� ��� ���� �̻��� ���� �Էµǹ����� �ذ� �ٸ��� ���ü� �־� ��Ÿ������ �����ߴ�.  
		for (int i = 1; i <= num; i++) {
			temp+=i;
			
		}
		System.out.println(temp);
		
		
	}

}
