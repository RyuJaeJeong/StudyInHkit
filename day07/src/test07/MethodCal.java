package test07;

import java.util.Scanner;

public class MethodCal {
	static void calculator(int first, String operator, int second) {
		if (operator.equals("+")) {
			System.out.println(first+second);
		} else if (operator.equals("-")) {
			System.out.println(first-second);
		} else if (operator.equals("*")) {
			System.out.println(first*second);
		} else   { 
			System.out.println(first/second);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int first = 0;
		int second = 0;
		String operator = "";
		
		
		while(true) {
			System.out.print("ù��° �ǿ����ڸ� �Է��ϼ��� ");
			first = sc.nextInt();
			if(first==0) break;
			sc.nextLine();
			System.out.print("�����ȣ�� �Է��ϼ���. ");
			operator = sc.nextLine();
			if(operator!="+"||operator!="-"||operator!="*"||operator!="/") continue;
			System.out.print("�ι�° �ǿ����ڸ� �Է��ϼ��� ");
			second = sc.nextInt();
			calculator(first,operator,second);
			
		}
		

	}

}
