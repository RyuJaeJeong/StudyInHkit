package exam03;

import java.util.Scanner;

public class TestCal {
public static void main(String[] args) {
	//����
	//�Է� : �μ� +-*/
	
Scanner sc = new Scanner(System.in);	
	
System.out.println("ù��° �ǿ����ڸ� �Է��ϼ��� : ");

double first = sc.nextDouble();

System.out.println("���� ��ȣ�� �Է��ϼ���(��, +-*/) : ");

String second = sc.next();

sc.nextLine();

System.out.println("�ι�° �ǿ����ڸ� �Է��ϼ��� : ");
	
double third = sc.nextDouble();
	
double ans;
int ans2;

if (second.equals("+")) {
	ans = first + third;
	ans2 = (int)ans; 
	System.out.println(ans2);
}else if(second.contentEquals("-")) {
	ans = first - third;
	ans2 = (int)ans;
	System.out.println(ans2);
}else if (second.equals("*")) {
	ans = first * third;
	ans2 = (int)ans;
	System.out.println(ans2);
}else if (second.equals("/")) {
    ans = first/third;
    System.out.println(ans);
}else {
	System.out.println("�����ȣ�� �߸� �Է��ϼ̽��ϴ�.!");
}







	
	
	
	
	
	
	
	
	
	
		}
	
}
