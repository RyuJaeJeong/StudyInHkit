package time_morning4;

import java.util.ArrayList;
import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<BookSale> b1 = new ArrayList<BookSale>();
		
		
		while(true) {
		System.out.println("���� (0:����, 1:���, 2:���, 3:����) : ");
		
		int imsi = sc.nextInt();
		sc.nextLine();
			if(imsi == 0) {
			break;
			}else if (imsi == 1) {
				if (b1.size() == 0) {
					System.out.println("==��Ͼ���.==\n");
				}else {
					for (int i = 0; i < b1.size(); i++) {
						b1.get(i).disp();
					}
				}
			
			}else if (imsi == 2) {
			    while (true) {
				System.out.println("å �̸� : ");
				String bookName = sc.nextLine();
					if (bookName.toLowerCase().equals("q"))
						break;
				System.out.print("�۰� : ");
				String author = sc.nextLine();
				sc.nextLine();
				System.out.print("���ǻ� : ");
				String maker = sc.nextLine();
				sc.nextLine();
				System.out.print("���ǿ��� : ");
				int year = sc.nextInt();
				sc.nextLine();
				System.out.print("���� : ");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.print("�Ǹż� : ");
				int amount = sc.nextInt();
				sc.nextLine();
				System.out.print("���� : ");
				int rank = sc.nextInt();
				sc.nextLine();
				b1.add(new BookSale(bookName,author,maker,year,price,amount,rank));
				}
			}else if(imsi ==3) {
				System.out.println("���° ����Ʈ�� ���� �Ͻðھ��?");
				int temp = sc.nextInt(); 
				
				System.out.println("å �̸� : ");
				String bookName = sc.nextLine();
				if (bookName.toLowerCase().equals("q"))
						break;
				System.out.print("�۰� : ");
				String author = sc.nextLine();
				sc.nextLine();
				System.out.print("���ǻ� : ");
				String maker = sc.nextLine();
				sc.nextLine();
				System.out.print("���ǿ��� : ");
				int year = sc.nextInt();
				sc.nextLine();
				System.out.print("���� : ");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.print("�Ǹż� : ");
				int amount = sc.nextInt();
				sc.nextLine();
				System.out.print("���� : ");
				int rank = sc.nextInt();
				sc.nextLine();
				
				b1.set(temp, new BookSale(bookName,author,maker,year,price,amount,rank));
				
			}
		}
		
		
		
		
		
		
		
	
		
		

	}

}
