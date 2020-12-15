package exam05;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		//반복문 : for. while, do ~ while
		
Scanner sc = new Scanner(System.in);

System.out.print("숫자를 입력하세요 : ");

int num = sc.nextInt();
int msg1 = 0;
int msg2 = 0;
int msg = 0;
while(num--!=1) { //후위 연산자. 조건을 비교한 후 빼줘라.
	if(num%2==0) {
		msg1 = msg1 + num;
	}else {
		msg2 = msg2 + num;
		
	} 
	 msg = msg1 + msg2;
	 
}

System.out.println("총 합계는 " + msg + "입니다." );
System.out.println("짝수의 총 합계는 " + msg1 + "입니다." );
System.out.println("홀수의 총 합계는 " + msg2 + "입니다." );
//입력 ; 정수
//출력 : 1~정수까지 합계
//1~정수까지 짝수합계
//1~정수까지 홀수합계
	
	
	
	

	
	
	//while문. 조건을 잘 봐라. 나갈 구멍을 꼭 만들어줘라. 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
