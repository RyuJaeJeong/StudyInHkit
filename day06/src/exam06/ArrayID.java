package exam06;

import java.util.Scanner;

public class ArrayID {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] PersonID;
		PersonID = new String[3];
		String msg = "";
		
		for(int i=0; i<=4; i++) {
		 
			
			System.out.print("�̸��� �Է��ϼ���. ");
			PersonID[0] = sc.nextLine();
			System.out.print("��������� �Է��ϼ���. ");
			PersonID[1] = sc.nextLine();
			PersonID[2] =Integer.toString(2020 - Integer.parseInt(PersonID[1]) + 1);
			
			
		
			msg = msg + "�̸� : " + PersonID[0] + "������� : " + PersonID[1] + " ���� : " + PersonID[2] + "\n";
		
		}
		
		System.out.println(msg);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}	