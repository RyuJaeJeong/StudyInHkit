package test07;

import java.util.Scanner;

public class ArrayReceipt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] goods = new String[3];
		String temp ="";
		int total = 0;
		for(int i=0; i<3; i++ ) {
			System.out.print("� ��ǰ�ΰ���? : ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.print("��ǰ�� ������ ���ΰ���? : ");
			String price = sc.nextLine();
			total = total + Integer.parseInt(price);
//			temp += name + "|\t";
//			temp += "....." + "|\t";
//			temp += price + "|\t\n";
//			goods = temp.split("\\|");
			goods[i] = name + "....." + price+"\n";
		}
		
		for(int i =0; i<goods.length; i++) {
			System.out.print(goods[i]);
		}
		
		//System.out.println("�հ�\t.....\t"+total);
		
	}

}
