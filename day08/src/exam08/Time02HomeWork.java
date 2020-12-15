package exam08;

import java.util.Scanner;

public class Time02HomeWork {

	static int sum(int num) {
		int tot = 0;
		for (int i = 0; i <=num; i++) {
			tot+=i;	
		}
		return tot;
	}
	static String print(int num) {
		int result = sum(num); //메서드 sum에서 리턴 값 가져온다.
		String print = "1부터 " + num +"까지의 합계는 "+ result + "입니다.";
		return print;
	}
	
	public static void main(String[] args) {
	System.out.println("숫자를 입력하면 1부터 숫자까지 합을 구해드립니다.!");
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	
	String sen = print(num);
	System.out.println(sen);
	
	
	
	}
}
