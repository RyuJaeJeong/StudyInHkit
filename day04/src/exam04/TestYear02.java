package exam04;

import java.util.Scanner;

public class TestYear02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ۿ���? : ");
		int a = sc.nextInt();
		sc.nextLine();
		System.out.print("������ ����? : ");
		int b = sc.nextInt();
		
			for(int i=a; i<=b; i++) {
				if ((i%100!=0 && i%4==0)||i%400==0) {
					System.out.println(i+" : "+"�����Դϴ�.");
				}else {
					System.out.println(i+" : "+ "����Դϴ�.");
				}
			}
		System.out.println("=======���α׷� ����=========");
		
		
		
		
		
	}

}
