package day16;

import java.util.Scanner;

public class Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		int i = 1;
		while(i>=1) {
			System.out.println("선택하세요(0:종료, 1:다음번호출력)");
			temp = sc.nextInt();
			if(temp==0) {
				break;
			}
			else if(temp==1) {
				System.out.println(i+"번째 손님 어서오세요!");	
			}
			i++;
			if(i>=5) i=1;
			
		}
	}
}


