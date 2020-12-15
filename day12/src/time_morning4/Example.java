package time_morning4;

import java.util.ArrayList;
import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<BookSale> b1 = new ArrayList<BookSale>();
		
		
		while(true) {
		System.out.println("선택 (0:종료, 1:목록, 2:등록, 3:수정) : ");
		
		int imsi = sc.nextInt();
		sc.nextLine();
			if(imsi == 0) {
			break;
			}else if (imsi == 1) {
				if (b1.size() == 0) {
					System.out.println("==목록없음.==\n");
				}else {
					for (int i = 0; i < b1.size(); i++) {
						b1.get(i).disp();
					}
				}
			
			}else if (imsi == 2) {
			    while (true) {
				System.out.println("책 이름 : ");
				String bookName = sc.nextLine();
					if (bookName.toLowerCase().equals("q"))
						break;
				System.out.print("작가 : ");
				String author = sc.nextLine();
				sc.nextLine();
				System.out.print("출판사 : ");
				String maker = sc.nextLine();
				sc.nextLine();
				System.out.print("출판연도 : ");
				int year = sc.nextInt();
				sc.nextLine();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.print("판매수 : ");
				int amount = sc.nextInt();
				sc.nextLine();
				System.out.print("순위 : ");
				int rank = sc.nextInt();
				sc.nextLine();
				b1.add(new BookSale(bookName,author,maker,year,price,amount,rank));
				}
			}else if(imsi ==3) {
				System.out.println("몇번째 리스트를 수정 하시겠어요?");
				int temp = sc.nextInt(); 
				
				System.out.println("책 이름 : ");
				String bookName = sc.nextLine();
				if (bookName.toLowerCase().equals("q"))
						break;
				System.out.print("작가 : ");
				String author = sc.nextLine();
				sc.nextLine();
				System.out.print("출판사 : ");
				String maker = sc.nextLine();
				sc.nextLine();
				System.out.print("출판연도 : ");
				int year = sc.nextInt();
				sc.nextLine();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.print("판매수 : ");
				int amount = sc.nextInt();
				sc.nextLine();
				System.out.print("순위 : ");
				int rank = sc.nextInt();
				sc.nextLine();
				
				b1.set(temp, new BookSale(bookName,author,maker,year,price,amount,rank));
				
			}
		}
		
		
		
		
		
		
		
	
		
		

	}

}
