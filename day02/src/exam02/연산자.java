package exam02;

public class 연산자 {

	public static void main(String[] args) {

//		//연산자
//		int a; //a를 선언. 
//		int b; //b를 선언.
//		int c; //c를 선언. 
//		
        //산술 연산자(+-*/%)
//		a = 7;
//		b = 5;
//		c = a + b;
//		System.out.println("a + b = " + c);
//		
//		
//		c = a - b;
//		System.out.println("a - b = " + c);
//		
//		c = a*b;
//		System.out.println("a x b = " + c);		
//				
//		double d;
//		
//		d = (double)a/b;
//		
//		System.out.println("a/b = " + d);
		
		
		
		
//		int x;
//		int y;
//		float r;
//		x = 5;
//		y = 3;
//		r = 0;
//		r = x+y;
//		r = x/y;
//		r=x%y;
//		System.out.println(r);
		
		
		//대입연산자
//		int a = 5;
//		a += 1; // a = a + 1
//		a -= 1; // a = a - 1
//		a *= 1; // a = a * 1
//		a /= 2; // a = a / 1
		
	//	System.out.println("a의 값은 " + a);
		
	//증감연산자 			
//	int a = 5; 
//	a++;//a = a+1, a += 1
//	++a;//마찬가지
//	a--;// a = a-1
//	--a;// a = a-1
//	System.out.println(a);
//	
//	전위 연산자, 후위 연산자 - 부호가 앞에있느냐 뒤에있느냐에 따라 계산 결과가 달라진다. 실수 많이하는 부분이니 중요하다.
//	int a = 5;
//	int b = 0;
//    b = a++;
//    System.out.println(a);
//    System.out.println(b);
//	
//    int x = 5;
//    int y = 0;
//    
//    y = ++x;
//    
//    System.out.println(x);
//    System.out.println(y);
    
	//비교연산자 - 조건
    /*
     * >  :  크다.
     * >= :  크거나 같다.
     * <  :  작다 
     * <= :  작거나 같다.
     * == : 같다.
     * != : 같지않다. 
     * */
    //컴퓨터에서 느낌표는 부정의 이미 !not
    
    
    
//    boolean q1 = 5 >  2;
//    boolean q2 = 5 >= 2;
//    boolean q3 = 5 < 2;
//    boolean q4 = 5 <= 2 ;
//    boolean q5 = 5 == 2;
//    boolean q6 = 5 != 2 ;
//    
//    System.out.println(q1);
//    System.out.println(q2);
//    System.out.println(q3);
//    System.out.println(q4);
//    System.out.println(q5);
//    System.out.println(q6);
   
    //논리연산자 : &&(and), ||(or), !(not)
//    int a = 5;
//    int b = 3;
//    int c = 9;
//    int d = 6;
//    boolean r;
//    
  //  r = a>b && c>d;
    //System.out.println("r : " + r);
    
    
    
    
    
    //산술, 대입, 증감, 비교, 논리
    //산술 > 비교(관계)> 논리 
    
   /* #&& : 둘 다 참일 때 참
    
    
    a	b	&&	||	!
    0	0   0	0	1
    0	1	0	1	1
    1   0	0	1   0
    1   1   1   1   0  */
    
    
    //삼항 연산자

    int a, b, c, d ;
    a = 5;
    b = 3;
    c = a > b ? 10 : 0; 
    System.out.println(c);
    
    d = a < b ? 10 : 0;
    System.out.println(d);
    
	
	
    
    
    boolean r =  5 > 3 && 3 > 2;
    
    System.out.println(r);   
    
    //비교연산자 논리연산자 잘 조합할 줄 알아야 한다. 
    //괄호를 우선으로 하되, 산술 > 비교 > 논리 
	
	
    
	}

}
