package iotByInterface;

public class Tv implements remoteController {

			//field
			String aptId;
			int channel;
			
			//cons
			public Tv(String aptId, int channel) {
				this.aptId = aptId;// TODO Auto-generated constructor stub
				this.channel = channel;
			}
			
			
			@Override
			public boolean on() {
				System.out.println(aptId+"의 tv가 켜졌습니다. (" + channel+"번)");
				return true;
			}

			@Override
			public boolean off() {
				System.out.println(aptId+"의 tv가 꺼졌습니다.");
				return false;
			}

}
