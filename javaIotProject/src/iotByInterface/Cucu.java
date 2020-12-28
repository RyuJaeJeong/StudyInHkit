package iotByInterface;

public class Cucu implements remoteController {
		//field
		String aptId;
		
		
		//cons
		public Cucu(String aptId) {
			this.aptId = aptId;// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public boolean on() {
			System.out.println(aptId+"의 밥솥이 취사를 시작했습니다.");
			return true;
		}

		@Override
		public boolean off() {
			System.out.println(aptId+"의 밥솥이 꺼졌습니다.");
			return false;
		}

}
