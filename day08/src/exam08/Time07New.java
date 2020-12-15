package exam08;

public class Time07New {
	//<멤버>필드는 초기화가 안되어있으면, 컴파일러가 컴파일 하면서 자동으로 초기화 시킨다.
	//String > null, int > 0 doeble> 0.0
	String fname;
	String lname;
	int age;
	
	public static void main(String[] args) {
		Time07New t1 = new Time07New();
		System.out.println(t1.lname);
		System.out.println(t1.fname);
		System.out.println(t1.age);
		
		t1.fname = "홍";
		t1.lname = "길동";
		t1.age = 19;
		
		Time07New t2 = new Time07New();
		
		t2.fname = "이";
		t2.lname = "성순";
		t2.age = 21;
		
		System.out.print(t2.fname);
		System.out.println(t2.lname);
		System.out.println(t2.age);
	}

}
