package test07;

import java.util.ArrayList;
import java.util.Scanner;

public class ListInList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList>list1 = new ArrayList();
		ArrayList<String> list2 = new ArrayList();
		
			for(int i=0; i<3; i++ ) {
			System.out.println("�̸��� �Է����ּ���. : ");
			list2.add(sc.nextLine());
			System.out.println("���������� �Է����ּ���. : ");
			list2.add(sc.nextLine());
			System.out.println("���������� �Է����ּ���. : ");
			list2.add(sc.nextLine());
			System.out.println("���������� �Է����ּ���. : ");
			list2.add(sc.nextLine());
			list1.add(i, list2);
			list2 = new ArrayList();
			}
		
			System.out.println(list1);
		
		
		
	}

}
