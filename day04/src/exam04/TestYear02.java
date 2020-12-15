package exam04;

import java.util.Scanner;

public class TestYear02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작연도? : ");
		int a = sc.nextInt();
		sc.nextLine();
		System.out.print("마지막 연도? : ");
		int b = sc.nextInt();
		
			for(int i=a; i<=b; i++) {
				if ((i%100!=0 && i%4==0)||i%400==0) {
					System.out.println(i+" : "+"윤년입니다.");
				}else {
					System.out.println(i+" : "+ "평년입니다.");
				}
			}
		System.out.println("=======프로그램 종료=========");
		
		
		
		
		
	}

}
