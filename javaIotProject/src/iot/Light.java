package iot;

public class Light {
	//field
	String aptId;
	//cons
	public Light(String aptId) {
		this.aptId = aptId;// TODO Auto-generated constructor stub
	}
	//method
	
	public boolean on() {
		System.out.println("light ON");
		return true;
	}
	
	public boolean off() {
		System.out.println("light OFF");
		return true;
		
	}
}
