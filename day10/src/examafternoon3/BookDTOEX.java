package examafternoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookDTOEX {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		System.out.println("å �̸�? : ");
		String name = in.readLine();
		System.out.println("�۰�? : ");
		String author = in.readLine();
		System.out.println("���ǻ�? : ");
		String maker = in.readLine();
		System.out.println("���ǿ���? : ");
		String year = in.readLine();
		System.out.println("�ܰ�? : ");
		int price = Integer.parseInt(in.readLine());
		System.out.println("�Ǹż���? : ");
		int number = Integer.parseInt(in.readLine());
		
		BookDTO b1 = new BookDTO(name, author, maker, year, price, number);
	}

}
