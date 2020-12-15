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
		int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; //자료형[]변수이름이 자바 권장사항.
		//정수형 배열 넘스에 10~100까지 담아라.
		
//		System.out.println("nums:" + nums); //주소를 출력하더라.
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
		
		int[] array = new int[10]; //크기를 만들어 버리면 더 늘리거나 줄이지는 못한다. "int"로 선언했기때문에 문자는 안들어간다. 
		
	//	System.out.println("array:" + array); //주소값
		//배열나오면 무조건 반복문
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
