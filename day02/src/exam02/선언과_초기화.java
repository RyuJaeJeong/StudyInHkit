package exam02;

public class 선언과_초기화 {

	public static void main(String[] args) {

		int age; //선언
		age = 20; //초기화 
		age = 30;
		
		final int AGE = 21;
		//AGE = 22; 이렇게 못한다. 상수는 값을 수정 할 수 없다. 상수는 선언과 동시에 초기화를 해야한다.  
		
		//System.out.println(Short.MIN_VALUE);
		
		boolean isTemp = true;
		
		int x = 10;
		int y = 7;
		//System.out.println(x>y);
       boolean isResult = x>y;
       System.out.println(isResult);
	}

}
