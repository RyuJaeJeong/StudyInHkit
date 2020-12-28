package iot;

public class Aircondition {

	
	//field
	String aptId;
	double desiredTemperature = 23.0;
	
	//cons
	public Aircondition(String aptId) {
		this.aptId = aptId;	// TODO Auto-generated constructor stub
	}
	
	//method
	public boolean on() {
		System.out.println("Aircon ON"+"("+desiredTemperature+")");
		return true;
	}

	public boolean off() {
		System.out.println("Aircon OFF");
		return true;
	}

}
