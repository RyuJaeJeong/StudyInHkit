 package exam08;

import java.util.Scanner;



public class Time01 {
	static void sum(int first, int second) {
		int third = first + second;
		System.out.println("�� ���� ���� "+ third + "�Դϴ�.");
	}
	
	static int sum02(int first, int second) {
		int third = first + second;
		return third;
		//��ȯ��, ����� ������ �ڷ���. �����̶�, ȣ�� ���ִ� ������ �����ִ°�.
	}
	public static void main(String[] args) {
		//�޼ҵ�� Ŭ���� �ȿ� ����������, �޼ҵ� �ȿ� �Ǵٸ� �޼ҵ尡 ���� �� ���� ����. 
		//static void insa(String name) {
		  	//static void insa(0 ) {
		  	//}
		  //}          �̷��Դ� �ȵȴٰ�.
		//�� ���� �Է� �޾Ƽ� ���� ���մϴ�. 
	Scanner sc = new Scanner(System.in);
	System.out.println("ù��° ���� ���� ����~ ");
	int first = sc.nextInt();
	System.out.println("�ι�° ���� ���� ����~ ");
	int second = sc.nextInt();
	
	//sum(first,second);
	
	
	
	
	
	
	//����(return)
	int result = sum02(first, second);
	System.out.println(result);
			
	
	
	
	
	
	
	
	
	
	}
}
