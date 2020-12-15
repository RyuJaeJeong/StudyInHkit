package Test09;

public class Time02 {

	int kor;
	int eng;
	int mat;
	int tot;
	double avg;
	
	//생성자 오버로딩
	// 여러개 깔아두고 원하는 것을 가져다쓴다. 자료형의 순서가 다르거나 변수의 갯수가 다르거나 해야한다. 
	public Time02() {
		// TODO Auto-generated constructor stub
	}
	
	public Time02(int k,int m, int e) {
		 kor = k;
		 eng = e;
		 mat = m;
		 tot = k+e+m;
		 avg = tot/3.;
		 
	}
	
	void display ( ) {
		String msg = "";
		msg = msg + "-----------------------------------------------\n";
		msg = msg + "국어\t영어\t수학\t총점\t평균\n";
		msg = msg + "-----------------------------------------------\n";
		msg = msg + kor;
		msg = msg + "\t";
		msg = msg + eng;
		msg = msg + "\t";
		msg = msg + mat;
		msg = msg + "\t";
		msg = msg + tot;
		msg = msg + "\t";
		msg = msg + avg;
		msg = msg + "\n";
		msg = msg + "-----------------------------------------------\n";		
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time02 t1 = new Time02(90,70,60);
		Time02 t2 = new Time02(80,60,50);
		Time02 t3 = new Time02(70,50,40);
		Time02 t4 = new Time02(); //얘는 기본 생성자를 이용하였음. 생성자는 어떻게 보면 객체를 초기화하는 기능이다. 
				
		t1.display();
		t2.display();
		t3.display();
	}

}
