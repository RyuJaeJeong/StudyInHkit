package Time_afernoon2;

public class use {

	public static void main(String[] args) {
		
		RemoteControl tv = new Tv();
		tv.turnOn();
		tv.turnOff();
		tv.setVolume(50);
		RemoteControl aud = new Audio();
		aud.turnOn();
		aud.turnOff();
		aud.setVolume(16);
		//인터페이스. 
		//인터페이스는 타입으로서 사용되는 곳이면 어디서든 사용이 가능하다.
		//인터페이스는 필드 매게변수 로컬변수 타입으로 선언가능하다.
		//인터페이스명 변수 = 구현객체
		
	
	}

}
