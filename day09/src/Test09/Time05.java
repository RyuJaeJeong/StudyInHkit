package Test09;

public class Time05 {
//필드, 생성자, 메소드
	//필드
	String str;
	int num;
	//생성자
	public Time05() {}
	//메소드. 재사용가능성이있는 것을 미리 등록 해놓고, 필요할때마다 호출.	
	void method1 () {
		System.out.println("--method1--");
	}
	
	void method1 (String name) {
		System.out.println(name + "님, 안녕하세요?");
	}
	void method1 (String name,int age ) {
		System.out.println("이름:" + name+"\n"+ "나이 : " + age);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static>공유의 개념. 객체 생성 하지않고도 누구나 다 
	Time05 t5 = new Time05();	
		t5.method1();
		t5.method1();
		t5.method1();
		
		t5.method1("홍길동");
		t5.method1("홍이동");
		t5.method1("홍삼동");
		
		t5.method1("류재정", 26);
	}
	

}
