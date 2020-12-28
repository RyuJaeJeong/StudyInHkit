package iot;

public class Light implements remoteController {

		//field
		String aptId;
		
		
		//cons
		public Light(String aptId) {
			this.aptId = aptId;// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public boolean on() {
			System.out.println(aptId+"의 전등이 켜졌습니다.");
			return true;
		}

		@Override
		public boolean off() {
			System.out.println(aptId+"의 전등이 꺼졌습니다.");
			return false;
		}
}
