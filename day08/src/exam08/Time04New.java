package exam08;

public class Time04New {
	static void test(int a, int b, int c) {
			a=100;
			System.out.println("a" + a);
			System.out.println("b" + b);
			System.out.println("c" + c);
	}
	
	
	
	
	public static void main(String[] args) {
		int[] nums = {10, 20, 30};
		test(nums[0], nums[1], nums[2]);  //test(10,20,30) 
		for (int i = 0; i < nums.length; i++) {
			System.out.println("(main)" + nums[i]);
		}			 
					 }
}
