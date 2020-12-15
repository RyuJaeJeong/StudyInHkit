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
		System.out.print("상품명을 입력해 주세요.");
		name = sc.nextLine();
		sc.nextLine();
		System.out.print("상품가격을 입력해 주세요.");
		price = sc.nextInt();
		sc.nextLine();
		msg =msg+ name+"....."+price+"\n";
		total = total + price;
		}
		System.out.println(msg+"합계....."+total);
	}
}
