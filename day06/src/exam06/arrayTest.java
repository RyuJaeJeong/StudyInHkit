package exam06;

public class arrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		int sum = num1 + num2 + num3 + num4 + num5;
		
		double avg = sum/(double)5;
		
		int tot = 0;
		tot+=num1;
		tot+=num2;
		tot+=num3;
		tot+=num4;
		tot+=num5;
		
//		System.out.printf("%d, %d, %f", sum, tot, avg);
//		System.out.println("\n----------------------------\n");
		int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; //�ڷ���[]�����̸��� �ڹ� �������.
		//������ �迭 �ѽ��� 10~100���� ��ƶ�.
		
//		System.out.println("nums:" + nums); //�ּҸ� ����ϴ���.
//		
//		System.out.println("nums[4] : " + nums[4] );
//		
		
		//System.out.println("nums[0] : " + nums[0]);
		
		int total = 0;
		int average = 0;
		for (int i=0; i<nums.length; i++) {
			total += nums[i];
		}
		
		average = total/nums.length;
		
	//	System.out.printf("%d, %d",total,average);
		
		int[] array = new int[10]; //ũ�⸦ ����� ������ �� �ø��ų� �������� ���Ѵ�. "int"�� �����߱⶧���� ���ڴ� �ȵ���. 
		
	//	System.out.println("array:" + array); //�ּҰ�
		//�迭������ ������ �ݺ���
//		array[0] =100;
//		array[1] =200;
//		array[2] =300;
//		array[3] =400;
//		array[4] =500;
		
	 int a = 100; /*
	for(int i = 0; i<array.length; i++ ) {
		
		array[i] =  a;
		a+=100; 
		System.out.println(array[i]);
	} */
	 
	 System.out.println(array.length);
	 
	          int i =0;                                                                        
	while(i<array.length) {
		array[i] =  a;
		a +=100; 
		
		System.out.println(array[i]);
		i++;
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
