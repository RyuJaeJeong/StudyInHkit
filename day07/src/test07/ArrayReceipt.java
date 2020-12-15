package test07;

import java.util.Scanner;

public class ArrayReceipt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] goods = new String[3];
		String temp ="";
		int total = 0;
		for(int i=0; i<3; i++ ) {
			System.out.print("어떤 상품인가요? : ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.print("상품의 가격은 얼마인가요? : ");
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
		
		//System.out.println("합계\t.....\t"+total);
		
	}

}
