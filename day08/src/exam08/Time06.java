package exam08;

public class Time06 {
	//클래스 내부에 들어가는 3개
	// <Member> Field (필드)
	// Constructor (생성자)
	// Member Method (메소드) - 메인 메소드.
	
	int x = 10;
	int y = 20;
	//여기가 Member Field - 클래스에 포함된 변수.. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Time06 c1 = new Time06();	//c1 객체, 인스턴스
		 System.out.println(c1.x);
		 System.out.println(c1.y);
		 c1.x = 100;
		 
		 System.out.println("c1은 " + c1);
		 
		 c1.y = 200;
		 
		 System.out.println("c1은" + c1.y);
		 
		 Time06 c2 = new Time06();  //c2 객체, 인스턴스 
		 System.out.println(c2.x);
		 System.out.println(c2.y);
	
		 Time06 c3 = new Time06();
		 System.out.println(c3.x);
		 System.out.println(c3.y);
	
	}
	
	

}
