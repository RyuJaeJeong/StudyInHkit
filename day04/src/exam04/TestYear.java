package exam04;

import java.util.Scanner;

public class TestYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է����ּ���.");
		int year = sc.nextInt();
		
		if ((year%100!=0 && year%4==0)||year%400==0) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("����Դϴ�.");
		}
		
		

	}

}
