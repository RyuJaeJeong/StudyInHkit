package test07;

import java.util.ArrayList;
import java.util.Scanner;

public class ListInList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList>list1 = new ArrayList();
		ArrayList<String> list2 = new ArrayList();
		
			for(int i=0; i<3; i++ ) {
			System.out.println("이름을 입력해주세요. : ");
			list2.add(sc.nextLine());
			System.out.println("국어점수를 입력해주세요. : ");
			list2.add(sc.nextLine());
			System.out.println("영어점수를 입력해주세요. : ");
			list2.add(sc.nextLine());
			System.out.println("수학점수를 입력해주세요. : ");
			list2.add(sc.nextLine());
			list1.add(i, list2);
			list2 = new ArrayList();
			}
		
			System.out.println(list1);
		
		
		
	}

}
