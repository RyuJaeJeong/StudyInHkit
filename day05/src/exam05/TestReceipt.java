package exam05;

import java.util.Scanner;

public class TestReceipt {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
    String name = "";
    int price = 0;
	String msg = "";
	int total = 0;
		for (int i=1; i<=5; i++) {
		System.out.print("��ǰ���� �Է��� �ּ���.");
		name = sc.nextLine();
		sc.nextLine();
		System.out.print("��ǰ������ �Է��� �ּ���.");
		price = sc.nextInt();
		sc.nextLine();
		msg =msg+ name+"....."+price+"\n";
		total = total + price;
		}
		System.out.println(msg+"�հ�....."+total);
	}
}
