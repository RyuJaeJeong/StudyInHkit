package ex01;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		String dbId = "hong";
		String dbPwd = "h1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ID�� �Է��ϼ���. ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ�� �Է��ϼ���. ");
		String pwd = sc.nextLine();		// ���̵�� ��й�ȣ �Է¹���. 
		
		if (id.equals(dbId)&&pwd.equals(dbPwd)) {	//�̸� ����� ���̵� ��й�ȣ��, �Էµ� ���� ��. 
			System.out.println("��ġ");
		} else {
			System.out.println("����ġ");
		}

	}

}
