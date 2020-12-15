package examafternoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookDTOEX {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		System.out.println("책 이름? : ");
		String name = in.readLine();
		System.out.println("작가? : ");
		String author = in.readLine();
		System.out.println("출판사? : ");
		String maker = in.readLine();
		System.out.println("출판연도? : ");
		String year = in.readLine();
		System.out.println("단가? : ");
		int price = Integer.parseInt(in.readLine());
		System.out.println("판매수량? : ");
		int number = Integer.parseInt(in.readLine());
		
		BookDTO b1 = new BookDTO(name, author, maker, year, price, number);
	}

}
