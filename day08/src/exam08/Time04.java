package exam08;

public class Time04 {
	static void imsi(int [] nums) {
		System.out.println(nums);
		nums[2] = 300;
		for (int i = 0; i < nums.length; i++) {
			System.out.print("�޼��� : "  + nums[i] + "\t");
		}
	}
		public static void main(String[] args) {
			int[] nums = {10, 20, 30, 40, 50};
			//System.out.println("nums : " + nums);
			
			
			
			imsi(nums); //�ӽö�� �޼��带 ȣ��
			System.out.println();
			for (int i = 0; i < nums.length; i++) {
			System.out.print("���� : " + nums[i] + "\t" );       //���� �޼����� nums �� imsi�޼����� nums 
															   // �ٸ� ������ �ֱ⶧���� �ٸ� ���̴�.
														       //�׷���, �迭�� Ư����. �� ������ ����Ǵ� ��  
			}													//�̶� �ٸ��޼��忡�� ���� �ٲ㵵 ���̶���� ���� �ٲ�� ������				
				 												//�Ű����Ѵ�. 	
	}
}
