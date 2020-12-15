package exam03;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		//입력 : 이름과 출생년도
		//출력 : 이름, 나이
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이릅을 입력하세요 : ");
		String name = scanner.nextLine();
		
		System.out.print("출생년도를 입력하세요 : ");
		int age = 2020 - scanner.nextInt() + 1;
		
		/*String msg = "";
		msg = msg + "당신의 이름은 ";
		msg = msg + name;
		msg = msg + "입니다.\n";
		msg = msg + "당신의 나이는 ";
		msg = msg + age;
		msg = msg + "세 입니다.";
		System.out.println(msg); */
		
		System.out.printf("당신의 이름은 %s입니다.\n 당신의 나이는 %d세 입니다.", name, age);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
