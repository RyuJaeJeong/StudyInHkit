package time_morning;

public class example {

	public static void main(String[] args) {
//		Parent p1 = new Parent();
//		System.out.println(p1.name); 
//		System.out.println(p1.number1);
//		Child c1 = new child();
//		System.out.println(c1.number2);
		
		//상속(Inheritance) : 부모한테서 물려받는것(Member)
		Child c1 = new Child();
		System.out.println(c1.name);//부모 객체의 멤버 필드. 
		System.out.println(c1.number1); //부모클래스 객체를 생성안했는데도 찍을 수 있다.
		System.out.println(c1.number2);
		

	}

}
