package exam08;

import java.util.Scanner;

public class Time03 {
	
static int sum(int num) {
	int tot = 0;
	for (int i = 0; i <=num; i++) {
		tot+=i;	
	}
	return tot;
}
static void print(int num, int total) {
	
	System.out.println( "1���� " + num +"������ �հ�� "+ total + "�Դϴ�.");
	
}

public static void main(String[] args) {
System.out.println("���ڸ� �Է��ϸ� 1���� ���ڱ��� ���� ���ص帳�ϴ�.!");
Scanner sc = new Scanner(System.in);
int num = sc.nextInt();


int result = sum(num);
print(num, result);

	}
}
