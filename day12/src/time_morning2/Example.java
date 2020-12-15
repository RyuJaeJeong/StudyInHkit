package time_morning2;

public class Example {

	public static void main(String[] args) {
		Exam2 e = new Exam2(); //상속을 하면 눈에는 안보이지만 부모객체 - 자식개체 모두 만들어진다. 
							   //부모생성자 먼저 실행되고 나중에 자식 생성자 실행된다.
		System.out.println(e.color1);
		System.out.println(e.color2);
		System.out.println(e.color3);
		System.out.println();
		System.out.println(e.getFlower1());
		System.out.println(e.getFlower2());
		System.out.println(e.getFlower3());
	
		e.test();
		
		//메소드 재정의 - 메소드 overriding
		
	}

}
