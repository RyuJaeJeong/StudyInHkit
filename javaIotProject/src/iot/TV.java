package iot;

public class TV {
	//field
	String aptId;
	int chanel = 41;
	//cons
	public TV() {
		// TODO Auto-generated constructor stub
	}
	//method
	public boolean on() {
		System.out.println("TV ON (" +chanel+")");
		return true;
	}
	
	public boolean off() {
		System.out.println("TV OFF");
		return true;
	}
}
