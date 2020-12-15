package exam01;

public class 자료형과_데이터타입 {
	public static void main(String[] args) {
/*
		//main method
		System.out.println("안녕하세요");
		System.out.println("홍길동");
		System.out.println("3+7 = " + 3+ 7 );
		//3+7 = 37
		System.out.println("3+7 = "+(3+7));
	    //3+7 = 10
		System.out.println("3+7=" + 3*7	);
		System.out.println("3+7 = " + (3*7));
		//변수 - 기본형 변수(primitive type), 참조형 변수 (reference type)
		
		 * 정수형 : byte(1byte),short(2byte) int(4byte) long(8byte)
		 * 실수형 : float(4byte), double(8byte)
		 * 문자형 : char(2byte)
		 * 논리형 : boolean
		 * 
		 * 1byte = 8bit ==>2**8
		 * 2byte = 16bit ==> 2**16
		 * 4byte = 32bit
		 * 8byte = 64bit 
		 * 00001111
		 
		//자료형, 데이터타입
		//number = 변수명, 개발자가 만든다. 
		//= 집어넣어라, 대입해라 , 오륵쪽의 값, 혹은 식의 결과를 왼쪽의 변수에 담아라. 대입연산자. 
		//5 : 값
//		int number = 5;
//		System.out.println(number);
System.out.println(Integer.MIN_VALUE);		
System.out.println(Integer.MAX_VALUE);

System.out.println(Short.MIN_VALUE);		
System.out.println(Short.MAX_VALUE);

int number = 5;
number = 10; // 자료형을 선언을 한 변수는 다시 선언하지 않습니다. 
System.out.println(number);
//변수 선언 및 초기화. 
int su;//변수 선언 int su = 100;
su = 100;//초기화 - 변수에 처음으로 값을 담는 것을 의미. 
System.out.println(su);
int num1 = 20+70//90이 들어갈 것이다.!
//------------------------------------------

//int a1,a2,a3;
//int = a1;
//int = a2;
//int = a3;

		byte a = 1;
				System.out.println(a);
				System.out.println(Byte.MAX_VALUE);
				System.out.println(Byte.MIN_VALUE);
				a = 100;
				System.out.println(a);
				a = 127;
				System.out.println(a);
				a = -128;
				System.out.println(a);
				
				float f = 3.14f;
				System.out.println(Float.MIN_VALUE);
				System.out.println(Float.MAX_VALUE);
				
				//정수형의 기본타입은 int이다. 
				//실수형의 기본타입은 double 이다. 

				//문자   : 글자1자
				//문자열 : 글자1자 이상

				
				int number1 = 80;
				int number2 = 90;
				long hab = number1 + number2; // 자동형변환(promotion) 작은 범위의 값을 더 큰 범위의 자료형에 집어넣을때 자동으로 들어가더라 
				short hap = (short)(number1 + number2);//강제형변환(Casting) 큰 범위의 값을 작은 범위의 자료형에 넣으려니 안들어가더라. 
				                                       //그래서 강제로 작은 범위 자료형으로 바꾸어 넣어준다. 
	int j1 = 30;
	int j2 = 50;
	System.out.println(j1 + j2);

	int j3 = j1 + j2;
	System.out.println(j3);  //실행 문장은 될수록 짧게짧게 쓰는 것이 좋다. 
	
	int j4 = j1 - j2;
	System.out.println(j4);

	int j5 = j1*j2;
	System.out.println(j5);
	
	j1 = 7;
	j2 = 2;
	
	
	int j6 = j1/j2;
	System.out.println(j6);
	
//정수와 정수를 연산하면 결과는 무조건 정수가 나온다. 

	int j7 = j1%j2; //나머지 구하는거. 
	System.out.println(j7);
	
	//산술연산. */
	
	String str1 = "대한";
	//System.out.print(str1);  //참조형 변수
	//String str1 = new String("대한");  참조형 변수, 얘도 클래스임 .

	
	String str2 = "민국";
	//System.out.println(str2);
	
	System.out.println(str1+str2);
	
	//문자열 + 문자열 => 나열되서 나온다.
	
	
	str1 = "6";
			str2 = "7";
	int nu1 = 2;
	
	System.out.println(str1 + str2 + nu1);
	
	//문자열 + 문자열 + 숫자(자동으로 문쟈열로 바뀐다.) 
	
	//변수 - 개발자 마음대로 만들면 된다. 
	// 자료형 변수이름 = 값 또는 식;
	//변수이름의 첫 글자는 숫자허용하지 않는다
	//변수이름의 첫글자로 _(언더바), $(달러화)도 가능하다고 한다. 가능은 하다만 거의 쓸일 없음. 
	
	String n1ame = "홍길동";
	String _nme = "홍길동";
	String $nme = "홍길동";
	
	char a = 3;
	System.out.println(a+3);
	
	}
}
