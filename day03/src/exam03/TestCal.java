package exam03;

import java.util.Scanner;

public class TestCal {
public static void main(String[] args) {
	//계산기
	//입력 : 두수 +-*/
	
Scanner sc = new Scanner(System.in);	
	
System.out.println("첫번째 피연산자를 입력하세요 : ");

double first = sc.nextDouble();

System.out.println("연산 기호를 입력하세요(예, +-*/) : ");

String second = sc.next();

sc.nextLine();

System.out.println("두번째 피연산자를 입력하세요 : ");
	
double third = sc.nextDouble();
	
double ans;
int ans2;

if (second.equals("+")) {
	ans = first + third;
	ans2 = (int)ans; 
	System.out.println(ans2);
}else if(second.contentEquals("-")) {
	ans = first - third;
	ans2 = (int)ans;
	System.out.println(ans2);
}else if (second.equals("*")) {
	ans = first * third;
	ans2 = (int)ans;
	System.out.println(ans2);
}else if (second.equals("/")) {
    ans = first/third;
    System.out.println(ans);
}else {
	System.out.println("연산부호를 잘못 입력하셨습니다.!");
}







	
	
	
	
	
	
	
	
	
	
		}
	
}
