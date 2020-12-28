package iot;

public class Elevator {

	//field
	String aptId;
	
	
	
	
	

	public Elevator(String aptId) {
		this.aptId = aptId;
	}
	
	public boolean goingUp(int nowFloor, int stopFloor) {
		System.out.println("엘리베이터가 "+nowFloor+"층에서 "+stopFloor+"층 으로 이동합니다.");
		return true;
	}
	
	public boolean goingDown(int nowFloor, int stopFloor) {
		System.out.println("엘리베이터가 "+nowFloor+"층에서 "+stopFloor+"층 으로 이동합니다.");
		return true;
	}

	public boolean goingNone(int nowFloor, int stopFloor) {
		System.out.println("현재층과 이동할 층이 동일합니다.");
		return false;
	}
}
