package Time_afernoon2;

public interface RemoteControl {
	
	public static final int Min_value = 0; //static final 안적어줘도 상관없다. 
	public static final int Max_value = 100;
	
	void turnOn();
	void turnOff();
	void setVolume(int i);

}
