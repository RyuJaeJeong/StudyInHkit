package exam08;

public class Time04 {
	static void imsi(int [] nums) {
		System.out.println(nums);
		nums[2] = 300;
		for (int i = 0; i < nums.length; i++) {
			System.out.print("메서드 : "  + nums[i] + "\t");
		}
	}
		public static void main(String[] args) {
			int[] nums = {10, 20, 30, 40, 50};
			//System.out.println("nums : " + nums);
			
			
			
			imsi(nums); //임시라는 메서드를 호출
			System.out.println();
			for (int i = 0; i < nums.length; i++) {
			System.out.print("메인 : " + nums[i] + "\t" );       //메인 메서드의 nums 와 imsi메서드의 nums 
															   // 다른 영역에 있기때문에 다른 것이다.
														       //그러나, 배열의 특성상. 힙 영역에 저장되는 것  
			}													//이라 다른메서드에서 값을 바꿔도 값이라던가 같이 바뀌기 때문에				
				 												//신경써야한다. 	
	}
}
