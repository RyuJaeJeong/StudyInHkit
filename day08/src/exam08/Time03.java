package exam08;

import java.util.Scanner;

public class Time03 {
	
static int sum(int num) {
	int tot = 0;
	for (int i = 0; i <=num; i++) {
		tot+=i;	
	}
	return tot;
}
static void print(int num, int total) {
	
	System.out.println( "1부터 " + num +"까지의 합계는 "+ total + "입니다.");
	
}

public static void main(String[] args) {
System.out.println("숫자를 입력하면 1부터 숫자까지 합을 구해드립니다.!");
Scanner sc = new Scanner(System.in);
int num = sc.nextInt();


int result = sum(num);
print(num, result);

	}
}
