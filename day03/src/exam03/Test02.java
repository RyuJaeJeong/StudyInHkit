package exam03;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		//�Է� : �̸��� ����⵵
		//��� : �̸�, ����
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = scanner.nextLine();
		
		System.out.print("����⵵�� �Է��ϼ��� : ");
		int age = 2020 - scanner.nextInt() + 1;
		
		/*String msg = "";
		msg = msg + "����� �̸��� ";
		msg = msg + name;
		msg = msg + "�Դϴ�.\n";
		msg = msg + "����� ���̴� ";
		msg = msg + age;
		msg = msg + "�� �Դϴ�.";
		System.out.println(msg); */
		
		System.out.printf("����� �̸��� %s�Դϴ�.\n ����� ���̴� %d�� �Դϴ�.", name, age);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
