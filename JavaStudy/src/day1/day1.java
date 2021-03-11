package day1;

public class day1 {

	public static void main(String[] args) {
		//두 변수의 값 교환하기
		int x = 10;
		int y = 20;
		
		System.out.println("교환전 x : " + x );
		System.out.println("교환전 y : " + y );
		
		//y의 값을 담아둘 임시변수 temp 선언
		int temp;
		temp = y;
		System.out.println("temp : " + temp);
		
		//y에 x의 값을 담는다. 
		y = x;
		
		//x에 y의 값을 담는다.
		x = temp;
		
		System.out.println("교환후 x : " + x );
		System.out.println("교환후 y : " + y );
	}

}
