package day16;

import java.util.Scanner;

public class Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		int i = 1;
		while(i>=1) {
			System.out.println("�����ϼ���(0:����, 1:������ȣ���)");
			temp = sc.nextInt();
			if(temp==0) {
				break;
			}
			else if(temp==1) {
				System.out.println(i+"��° �մ� �������!");	
			}
			i++;
			if(i>=5) i=1;
			
		}
	}
}


