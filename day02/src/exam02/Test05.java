package exam02;

public class Test05 {

	public static void main(String[] args) {
		// 형변환 : 자동형변환(Promotion), 강제형변환(Casting)
		//        묵시적형변환                    명시적형변환
		// 하나의 타입을 다른 타입으로 바꾸는 것. 
		//상대적으로 작은 타입에서 큰 타입으로의 타입변환은 생략할 수 있습니다.
		//큰 타입에서 작은 타입으로의 타입 변환은 데이터 손실이 발생합니다. 
		
		
		
		int intValue = 7;
		double doublevalue = 3.0;   // 자동형변환
		doublevalue = intValue;
		System.out.println(doublevalue);
		
		
		//long : 8byte
		//double : 8byte 
		
		double dValue1 = 8.53;
		int iValue1 = 5;
		iValue1 = (int)dValue1;
		System.out.println(iValue1);
		//0.53이 유실되었다. 될수 있으면 이렇게 안쓰는 것이 제일 좋다. 
		
		
		System.out.println(Byte.MIN_VALUE +" ~ "+ Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE +" ~ "+ Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE +" ~ "+ Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE +" ~ "+ Long.MAX_VALUE);
		System.out.println(Float.MIN_VALUE +" ~ "+ Float.MAX_VALUE);
		System.out.println(Double.MIN_VALUE +" ~ "+ Double.MAX_VALUE);
		int i1 = 130;
		byte b1 = (byte)i1;
		System.out.println(b1);   //이런 식으로 우리가 예측 못하는 값이 나오기도 하니까 반.드.시 찍어봐야 한다. 
		
		long a = 123L;
		
		float bb = 123f; 
		
		
		
	}

}
