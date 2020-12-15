package test07;

import java.util.Scanner;

public class MethodReceipt {

	static void receipt(String name, String price) {
		System.out.println("입력하신 상품은 " + name + "이며" + " 가격은 " + price + "입니다.");
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		String price ="";
		
		while(true) {
		System.out.print("상품 이름을 입력하세요 : ");
		name = sc.nextLine();
		if(name.toLowerCase().equals("q")) break;
		System.out.print("상품 가격을 입력하세요 : ");
		price = sc.nextLine();
		receipt(name, price);
		}
		System.out.println("--프로그램 종료--");
	}

}
