package exam06;

import java.util.Scanner;

public class ArrayID {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] PersonID;
		PersonID = new String[3];
		String msg = "";
		
		for(int i=0; i<=4; i++) {
		 
			
			System.out.print("이름을 입력하세요. ");
			PersonID[0] = sc.nextLine();
			System.out.print("생년월일을 입력하세요. ");
			PersonID[1] = sc.nextLine();
			PersonID[2] =Integer.toString(2020 - Integer.parseInt(PersonID[1]) + 1);
			
			
		
			msg = msg + "이름 : " + PersonID[0] + "출생연도 : " + PersonID[1] + " 나이 : " + PersonID[2] + "\n";
		
		}
		
		System.out.println(msg);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}	