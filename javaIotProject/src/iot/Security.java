package iot;

public class Security {

//field
String aptId;
//cons
public Security(String aptId) {
	this.aptId = aptId;// TODO Auto-generated constructor stub
}	
	//method
	
	public boolean on() {
		System.out.println("Security ON");
		return true;
	}
	
	public boolean off() {
		System.out.println("Security OFF");
		return true;
	}
}
