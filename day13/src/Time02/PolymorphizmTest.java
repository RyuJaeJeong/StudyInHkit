package Time02;

public class PolymorphizmTest {
	public static void main(String[] args) {
		Animal ani = new Animal();
		ani.sound();
		
		Animal ani02 = new Dog();
		ani02.sound(); //자동형변환 , 부모타입의 변수에 자식 객체를 집어넣으니까 자동 형변환이 일어나더라. 사용할수있는 멤버는  부모 멤버. 
		
		Animal ani03 = new Cat();
		ani03.sound();
		
		Animal ani04 = new Bird();
		ani04.sound();
		
	/*
	 *  다형성 :  형변환 + 오버라이딩 
	 *  부모타입의 변수에 자식객체를 집어넣는것 
	 *  부모타입에 집어 넣었기 때문에 사용할수 있는 멤버는 부모의 것만 가능
	 *  그러나 메소드 재정의가 되어있으면 부모것이 아닌 자식것 실행.
	 * 
	 *객체지향 프로그램 4대 특징
	 *캡슐화(은닉화)
	 *상속
	 *다형성
	 *추상화 
	 * */
		 
		
		System.out.println("--------------");
		ani = new Animal();
		ani.dispA();
		ani.sound();
		ani = new Dog();
		ani.dispA();
		ani.sound();
		ani = new Cat();
		ani.dispA();
		ani.sound();
		ani = new Bird();
		ani.dispA();
		ani.sound();
	}
}
