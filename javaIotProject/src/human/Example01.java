package human;

import iot.Aircondition;
import iot.Cucu;
import iot.Elevator;
import iot.Light;
import iot.Security;

public class Example01 {

	public static void main(String[] args) {
		
			String aptId = "XII/101/101";
			
		Elevator elevator = new Elevator(aptId);
		
		elevator.goingUp(1, 5);
		elevator.goingNone(1, 1);
		elevator.goingDown(5, 1);
		
		Security security = new Security(aptId);
		
		security.on();
		security.off();
		
		Aircondition aircon = new Aircondition(aptId);
		
		aircon.on();
		aircon.off();
		
		Light light = new Light(aptId);
		
		light.on();
		light.off();
		
		Cucu cucu = new Cucu(aptId);
		
		cucu.on();
	}

}
