package iot;

public class Tv implements remoteController {

			//field
			String aptId;
			
			
			//cons
			public Tv(String aptId) {
				this.aptId = aptId;// TODO Auto-generated constructor stub
				
			}
			
			
			@Override
			public boolean on() {
				System.out.println(aptId+"의 tv가 켜졌습니다.");
				return true;
			}

			@Override
			public boolean off() {
				System.out.println(aptId+"의 tv가 꺼졌습니다.");
				return false;
			}

}
