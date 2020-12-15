package test07;

import java.util.Scanner;

public class MethodTest {
	
	//접근제한자 반환형 메소드명()
	//메소드는 자체적으로는 실행이 안된다.
	//누군가가 호출을 해야만 실행이 된다.
	static void insa() {
		System.out.println("홍길동");
		System.out.println("안녕하세요?");
	}
	
	static void insa2(String name) { //파라미터 
		
		System.out.println(name +"님 안녕하세요?");
	}
	
	static void insa3(int kor, int eng, int mat) { //파라미터 
		int total = kor + eng + mat;
		System.out.println("총점은" + total +"입니다.");
	}
	
	static void qqt(int dan) { //파라미터 
		for (int j=1; j<10; j++) {
			System.out.printf("%d * %d = %d\n", dan, j, dan*j);
		}
	}
	
	
	public static void main(String[] args) {
		
//			insa(); //호출
//			insa2("류재정");
//			insa3(90, 80, 70);
//			insa3(50, 60, 70);//아규먼트
//			 for(int dan=2; dan<10; dan++) {
//				qqt(dan);
//			}
			//메개변수, 인자, 파라미터, 아규먼트
		Scanner sc = new Scanner(System.in);
		System.out.print("단을 입력하세요 : ");
		int dan = sc.nextInt();
		qqt(dan);
	}
}
