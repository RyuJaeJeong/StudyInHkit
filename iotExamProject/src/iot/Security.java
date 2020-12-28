package iot;

public class Security implements remoteController {

	//field
			String aptId;
			
			
			//cons
			public Security(String aptId) {
				this.aptId = aptId;// TODO Auto-generated constructor stub
			}
			
			
			@Override
			public boolean on() {
				System.out.println(aptId+"의 잠금이 열렸습니다.");
				return true;
			}

			@Override
			public boolean off() {
				System.out.println(aptId+"의 잠금이 닫혔습니다.");
				return false;
			}
}
