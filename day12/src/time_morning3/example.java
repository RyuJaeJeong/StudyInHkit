package time_morning3;

public class example {
//객체지향 프로그램의 4대 특성
	/*
	 * 캡슐화 : Getter&Setter
	 * 상속 : 부모의 멤버를 물려 받는것. 재정의 
	 * 추상화 : 곧 배울꺼
	 * 다형성 : 
	 * */
	public static void main(String[] args) {
		dog d1 = new dog("바둑이",3); //부모 생성자가 먼저 실행되기때문에 넣어줘야한다. 
		System.out.println(d1.age);
		System.out.println(d1.name);
		d1.sound(); //
		d1.display();
		cat c1 = new cat("애비",5);
		c1.sound();
		
		c1.display();
		
		bird b1 = new bird("릴리",2);
		b1.sound();
		b1.display();
	}

}
