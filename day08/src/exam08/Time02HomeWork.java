package exam08;

import java.util.Scanner;

public class Time02HomeWork {

	static int sum(int num) {
		int tot = 0;
		for (int i = 0; i <=num; i++) {
			tot+=i;	
		}
		return tot;
	}
	static String print(int num) {
		int result = sum(num); //�޼��� sum���� ���� �� �����´�.
		String print = "1���� " + num +"������ �հ�� "+ result + "�Դϴ�.";
		return print;
	}
	
	public static void main(String[] args) {
	System.out.println("���ڸ� �Է��ϸ� 1���� ���ڱ��� ���� ���ص帳�ϴ�.!");
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	
	String sen = print(num);
	System.out.println(sen);
	
	
	
	}
}
