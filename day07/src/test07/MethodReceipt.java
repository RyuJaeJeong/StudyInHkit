package test07;

import java.util.Scanner;

public class MethodReceipt {

	static void receipt(String name, String price) {
		System.out.println("�Է��Ͻ� ��ǰ�� " + name + "�̸�" + " ������ " + price + "�Դϴ�.");
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		String price ="";
		
		while(true) {
		System.out.print("��ǰ �̸��� �Է��ϼ��� : ");
		name = sc.nextLine();
		if(name.toLowerCase().equals("q")) break;
		System.out.print("��ǰ ������ �Է��ϼ��� : ");
		price = sc.nextLine();
		receipt(name, price);
		}
		System.out.println("--���α׷� ����--");
	}

}
