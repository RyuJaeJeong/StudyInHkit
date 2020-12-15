package exam05;

import java.util.Scanner;

public class TestUnlimitedReceipt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    String name = "";
	    int price = 0;
		String msg = "";
		int total = 0;
		int num = 0;
		int point = 0;
		int totalPoint = 0;
			for (;;) {
			System.out.print("상품명을 입력해 주세요.");
			name = sc.nextLine();
			
			if(name.toLowerCase().equals("q")) {
				break;
			}
			System.out.print("상품가격을 입력해 주세요.");
			price = sc.nextInt();
			sc.nextLine();
			System.out.print("상품 수량을 입력해 주세요.");
			num = sc.nextInt();
			sc.nextLine();
			int allPrice = num*price;
			total = total + allPrice;
			if (allPrice >=5000) {
				point =  allPrice * 10/100;}
			else {
				point = 0;
			}
			totalPoint = totalPoint + point;
			msg =msg+ name+"..... "+num+"개 ....."+allPrice+"원"+"("+price+"원"+")"+"....."+point+"p"+"\n";
			
			
			}
			System.out.println(msg+"합계.........."+total+"........"+totalPoint);
			System.out.println("프로그램 종료");
	}

}
