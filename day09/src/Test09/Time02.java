package Test09;

public class Time02 {

	int kor;
	int eng;
	int mat;
	int tot;
	double avg;
	
	//������ �����ε�
	// ������ ��Ƶΰ� ���ϴ� ���� �����پ���. �ڷ����� ������ �ٸ��ų� ������ ������ �ٸ��ų� �ؾ��Ѵ�. 
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
		msg = msg + "����\t����\t����\t����\t���\n";
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
		Time02 t4 = new Time02(); //��� �⺻ �����ڸ� �̿��Ͽ���. �����ڴ� ��� ���� ��ü�� �ʱ�ȭ�ϴ� ����̴�. 
				
		t1.display();
		t2.display();
		t3.display();
	}

}
