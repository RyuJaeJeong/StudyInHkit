package exam03;

import java.util.Scanner;

public class TestCalSwitch {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° �ǿ����ڸ� �Է��ϼ��� : ");
		int first = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ��ȣ�� �Է��ϼ��� (+-*/) : ");
		String second = sc.nextLine();
		sc.nextLine();
		System.out.print("�ι�° �ǿ����ڸ� �Է��ϼ��� : ");
		int third = sc.nextInt();
		sc.nextLine();
		
		int ans;
		double result;
		
		switch(second) {
		case "+" :
			ans = first + third;
		case "-" :
			ans = first - third;
		case "*" :
			ans = first*third; 
		case "/"  : 
			result = (double)first/third;
		default :
			System.out.println("�����ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			
			
			
		}
		
		
	}
	

}
