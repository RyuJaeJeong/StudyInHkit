package ex02;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
	
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1부터 입력한 값까지의 합을 구해드립니다! ");
		int num = sc.nextInt();
		long temp = 0;				//1부터 n까지의 값을 누적하는 임시변수, int 타입으로 정의 할 경우 일정 이상의 값이 입력되버리면 해가 다르게 나올수 있어 롱타입으로 정의했다.  
		for (int i = 1; i <= num; i++) {
			temp+=i;
			
		}
		System.out.println(temp);
		
		
	}

}
