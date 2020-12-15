package exam03;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in); //키보드로 입력받는 프로그램
	//System.out.print("숫자를 입력하세요 : ");
    //int num1 = scanner.nextInt(); //숫자를 입력받는다.
    //System.out.println(num1);
		
//	System.out.print("주소를 입력하세요 : ");	
//	String address = scanner.next(); //첫번째 공백 앞에까지만 인식을 해준다. 
//	scanner.nextLine(); //키보드 버퍼를 비우는 역활을 한다. 
//	System.out.print("이름을 입력하세요 : ");
//	String name = scanner.nextLine(); //전체 라인을 인식한다.
//	System.out.println(address);
//	System.out.println(name);

		
		//키보드 입력 -> 키보드버퍼 -> num1
		//next() : 문자열을 입력 받는데, 뛰어쓰기 전까지만 입력받는다.
	    //nextLine() : 문자열을 입력받는데, 한 줄 전체를 입력받는다. nextLine()메소드는 키보드 버퍼가 비어있으면 입력을 요구하지만, 비어있지않으면 버퍼의 전체내용을 읽어온다. 
		
		
System.out.print("숫자를 입력하세요 : ");		
int num1 = scanner.nextInt();

scanner.nextLine();

System.out.println("주소를 입력하세요 : ");
String address = scanner.nextLine();

System.out.println(num1);
System.out.println(address);


		
		
		
		
		
	}
	
	
	
}
