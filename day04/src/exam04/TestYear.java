package exam04;

import java.util.Scanner;

public class TestYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도를 입력해주세요.");
		int year = sc.nextInt();
		
		if ((year%100!=0 && year%4==0)||year%400==0) {
			System.out.println("윤년입니다.");
		} else {
			System.out.println("평년입니다.");
		}
		
		

	}

}
