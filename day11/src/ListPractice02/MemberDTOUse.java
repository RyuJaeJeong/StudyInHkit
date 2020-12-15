package ListPractice02;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberDTOUse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String id;
		int price;
		String temp;
		ArrayList<MemberDTO> arr = new ArrayList<>();
		while(true) {
			System.out.println("이름 : ");
			temp = sc.nextLine();
			if(temp.toLowerCase().equals("q")) break;
			name = temp;
			System.out.println("id : ");
			id = sc.nextLine();
			System.out.println("총 구매가격 : ");
			price = sc.nextInt();
			arr.add(new MemberDTO(name,id,price));
		}
		
	}

}
