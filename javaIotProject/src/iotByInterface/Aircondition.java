package iotByInterface;

public class Aircondition implements remoteController {
	//field
	String aptId;
	Double desiredTemp = 18.0;
	
	//cons
	public Aircondition(String aptId, double desiredTemp) {
		this.aptId = aptId;// TODO Auto-generated constructor stub
		this.desiredTemp = desiredTemp;
	}
	
	
	@Override
	public boolean on() {
		System.out.println(aptId+"의 에어컨이 켜졌습니다. ("+desiredTemp+"º)");
		return true;
	}

	@Override
	public boolean off() {
		System.out.println(aptId+"의 에어컨이 꺼졌습니다.");
		return false;
	}

}


