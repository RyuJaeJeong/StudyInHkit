package ex01;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		String dbId = "hong";
		String dbPwd = "h1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ID를 입력하세요. ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요. ");
		String pwd = sc.nextLine();		// 아이디와 비밀번호 입력받음. 
		
		if (id.equals(dbId)&&pwd.equals(dbPwd)) {	//미리 선언된 아이디 비밀번호와, 입력된 값을 비교. 
			System.out.println("일치");
		} else {
			System.out.println("불일치");
		}

	}

}
