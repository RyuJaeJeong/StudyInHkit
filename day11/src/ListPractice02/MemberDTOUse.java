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
			System.out.println("�̸� : ");
			temp = sc.nextLine();
			if(temp.toLowerCase().equals("q")) break;
			name = temp;
			System.out.println("id : ");
			id = sc.nextLine();
			System.out.println("�� ���Ű��� : ");
			price = sc.nextInt();
			arr.add(new MemberDTO(name,id,price));
		}
		
	}

}
