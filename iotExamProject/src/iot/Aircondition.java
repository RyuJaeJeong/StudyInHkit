package iot;

public class Aircondition implements remoteController {
	//field
	String aptId;
	Double desiredTemp = 18.0;
	
	//cons
	public Aircondition(String aptId) {
		this.aptId = aptId;// TODO Auto-generated constructor stub
		
	}
	
	
	@Override
	public boolean on() {
		System.out.println(aptId+"의 에어컨이 켜졌습니다.");
		return true;
	}

	@Override
	public boolean off() {
		System.out.println(aptId+"의 에어컨이 꺼졌습니다.");
		return false;
	}

}


