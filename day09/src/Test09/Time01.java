package Test09;

import java.util.Scanner;
//멤버필드, 생성자, 메소드. 
//바이트코드.class 기계가 인식하는 언어. 이렇게 한 파일에 클래스 두개 만들면, src에 소스 파일은 하나인데
// 컴파일 하면 class는 두개가된다. 
class Temp  {
	//Field
	//Constructor 
	//Method 
	
	

	int kor;//멤버 필드는 초기화를 안해도 컴파일 할때 자동으로 초기화 해준다. 
	int eng;
	int mat;
	int total;
	double avg;
	String name;
	
	
	
public Temp(int k, int e , int m) {        //생성자는  반환형이 없다. 
	kor = k;
	eng = e;
	mat = m;
	total = k+e+m;
	avg = total/3.0;
	}
	
	
	
	
	
void display() { //void - 메소드 안의 명령들을 실행하고 끝내라는뜻. 리턴값없다는 뜻
	
		String msg = "";
		msg = msg + "-----------------------------------------------\n";
		msg = msg + "국어\t영어\t수학\t총점\t평균\n";
		msg = msg + "-----------------------------------------------\n";
		msg = msg + kor;
		msg = msg + "\t";
		msg = msg + eng;
		msg = msg + "\t";
		msg = msg + mat;
		msg = msg + "\t";
		msg = msg + total;
		msg = msg + "\t";
		msg = msg + avg;
		msg = msg + "\n";
		msg = msg + "-----------------------------------------------\n";		
		System.out.println(msg);
		
		
	}
}

public class Time01 {
	
	
	
	
	public static void main(String[] args) {
		int a; //얘는 멤버  필드가 아니라서 자동으로 초기화 시켜주지 않는다. 
		//같은패키지에는 동일한 이름의 클래스 못쓴다. 
		//자료형 변수 = new 생성자(); 생성자는 클래스 이름과 동일한 메소드
		Scanner sc = new Scanner(System.in);
		System.out.println("국어: ");
		a = sc.nextInt();
		System.out.println("영어: ");// TODO Auto-generated constructor stub
		int b = sc.nextInt();
		System.out.println("수학: ");
		int c = sc.nextInt();
		
		
		Temp t1 = new Temp(a,b,c); //객체를 만들어서 t1에 담아라 . 객체를 형성하면 자동으로 초기화된다. 
								   // 객체를 만들어서 값을 직접 입력하는 방법이 있고, 또 입력을 편하게 받고
								   //싶으면 입력 메서드를 따로 만드는 방법도 있다. 그리고. 객체 생성전에 메인 메서드에서
									//입력받은 값을 기본생성자 단계에서 객체에 때려넣는 방법도있다. 
									// 기본 생성자에서 입력 받는 방법도 있다. 
		t1.display();
//		t1.kor = 90;
//		t1.eng = 80;
//		t1.mat = 70;
//		t1.total = t1.kor + t1.eng + t1.mat;
//		t1.avg = (double)t1.total / 3; //자동형변환.

		
		
//		Temp t2 = new Temp();
//		t2.kor = 99;
//		t2.eng = 88;
//		t2.mat = 77;
//		t2.total = t2.kor + t2.eng + t2.mat;
//		t2.avg = (double)t2.total/3;
//		t2.display();
		
		
		
	}

}
