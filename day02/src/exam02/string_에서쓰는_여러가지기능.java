package exam02;

public class string_에서쓰는_여러가지기능 {
public static void main(String[] args) {
	//String : 문자열
//	String insa = "welcome to my site!!!";
//	//String insa = new String("welcome to my site!!!") 스트링은 기본자료형은 아니다.
//	System.out.println(insa);
//	insa = "안녕하세요?";
//	System.out.println(insa);
//	insa = "9 * 3 + 2 - 8";
//	System.out.println(insa); //숫자하고 문자 구분하는 기준이 뭐냐? 큰 따움표 ""

	//함수
	//메소드 .length 는 ~ 안에서 길이니까 범위가 정해져있음.따라서 메소드 
	
	String alpabet = "abcdefghijklmnopqrstuvwxyz";
	//System.out.println(alpabet.length());  //길이구하기
	
	//System.out.println("alpabet값의 길이는 " + alpabet.length() + "입니다.");
//string 값의 길이를 구할수 있구나. 
	int i = 1234567789;
	//System.out.println(i.length()); 스트링 타입에서 사용하지, 정수형에서는 사용하지 못한다. 
	
	String txt = "welcome to my site !!!";
			//System.out.println(txt.toUpperCase()); //대문자로 바꾸기
			
			String txt2 = txt.toUpperCase();
			
			//System.out.println(txt2.toLowerCase()); //소문자로 구하기 


			//index(인덱스) - 위치값, 0부터 시작한다. 
			System.out.println(txt.indexOf("to"));   //8을 리턴한다. 다른말이 있는것은 아니고 그냥 돌려준다는 뜻이다. 
			System.out.println(txt.length());



String memo1 = "jeong's site !!!";
System.out.println(memo1);

String memo2 = "나의 고향은 '대구' 입니다.";
System.out.println(memo2);

String memo3 = "나의 고향은 '대구'이며, \n회사는 \t'경기도'입니다.";   
System.out.println(memo3);


String firstName = "hong";
String lastName = "kildong";
System.out.println(firstName + "\n" +lastName);
System.out.println(firstName.concat(lastName));//.concat() 문자열 연결 

String result = firstName + " " + lastName;

System.out.println(result);

long myNum = 10000000000L;





String str = "happy new year!!!";

System.out.println(str.length());
System.out.println(str.indexOf("n"));




String temp = "010-5657-8990";
String[] temps = temp.split("-");
System.out.println(temps.length);
System.out.println(temps[0]);
System.out.println(temps[1]);
System.out.println(temps[2]);
	}
}
