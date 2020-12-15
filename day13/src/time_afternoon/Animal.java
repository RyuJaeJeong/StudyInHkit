package time_afternoon;


//클래스내에 추상메서드가 하나라도 포함되어 있으면
//그 클래스는 추상 클래스가 된다. 추상클래스는 class앞에 abstract를 붙여야한다.
//추상클래스는 직접 객체를 생성할 수 없다. 
public abstract class Animal {
	public abstract void sound();  //추상 메서드. 
	
	
	public Animal() {
		System.out.println("animal");
	}
	
	public void display () {
		System.out.println("--Animal disp--");
	}

}
/*
 * 추상클래스
 * 실체 클래스의 설계 규격 - 객체생성용이 아님
 * 클래스들의 공통적인 필드와 메소드를 추출하여 선언한 클래스
 * 추상클래스를 이용하여 다형성을 구현할 수 있다.
 * 
 * 추상 메소드
 * 추상 클래스에서만 선언할 수 있고, 메소드의 선언부만 있는 메소드. 
 * 자식클래스에서 재정의되어 실행내용을 결정해야함
 * 
 */