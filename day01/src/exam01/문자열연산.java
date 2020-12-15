package exam01;

public class 문자열연산{

	public static void main(String[] args) {
		
		String name = "홍길동";
		int age = 19; 
		
//		System.out.println("입력하신 이름은 "+name+ "이며, 나이는 " + age + "세입니다.");
//		//문자열 연산을 이용하면 됩니다. 
//		
//		String message = "";
//		message = message + "입력하신 이름은 ";
//		message = message + name;
//		message = message + "이며, 나이는 ";
//		message = message + age;
//		message = message + "세 입니다.";
//			System.out.println(message);
//문자열 : 문자열 + 문자열 + 문자열 + 숫자 + 문자열 (숫자가 문자로 바뀌어 버리며 문자가 나열되서 나온다.
//문자열 연산에서는 띄워쓰기, 공백 확인 중요하다..!!!!
			
			System.out.printf("당신의 이름은 %s입니다.", name);
			System.out.printf("당신의 나이는 %d입니다.", age);
			System.out.printf("당신의 나이는 %s입니다.", age);
			
			//print f : %d(정수) %f(실수) %c(문자) %s(문자열)
			
	String message = "";
	message = message + "\n당신의 이름은 ";
	message = message + name;
	message = message + " 입니다.";
	message = message + "당신의 나이는";
    message = message + age;
	message = message + "세 입니다.";
	
	System.out.println(message);
	
	
	
	char aaa = 'A';
	
	System.out.println("\n" + aaa );
	
	
	//unsigned : 양수만 존재. 
	
	}

}
