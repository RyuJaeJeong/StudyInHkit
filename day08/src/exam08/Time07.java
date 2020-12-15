package exam08;

public class Time07 {
	int x = 10;
	int y = 20;
	public static void main(String[] args) {
		//클래스는 무조건 객체를 생성하고 사용하자.
		//자료형 변수 = new 생성자 ();
		//생성자는 클래스 이름과 동일한 메소드이다.
	
		Time07 time07 = new Time07();
		System.out.println(time07.x);
		System.out.println(time07.y);
		
		time07.x = 10000;
		System.out.println(time07.x);
		
		Time07 time08 = new Time07();
		System.out.println(time08.x);
		System.out.println(time08.y);
	
	}
	
}
