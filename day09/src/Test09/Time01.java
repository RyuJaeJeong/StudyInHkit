package Test09;

import java.util.Scanner;
//����ʵ�, ������, �޼ҵ�. 
//����Ʈ�ڵ�.class ��谡 �ν��ϴ� ���. �̷��� �� ���Ͽ� Ŭ���� �ΰ� �����, src�� �ҽ� ������ �ϳ��ε�
// ������ �ϸ� class�� �ΰ����ȴ�. 
class Temp  {
	//Field
	//Constructor 
	//Method 
	
	

	int kor;//��� �ʵ�� �ʱ�ȭ�� ���ص� ������ �Ҷ� �ڵ����� �ʱ�ȭ ���ش�. 
	int eng;
	int mat;
	int total;
	double avg;
	String name;
	
	
	
public Temp(int k, int e , int m) {        //�����ڴ�  ��ȯ���� ����. 
	kor = k;
	eng = e;
	mat = m;
	total = k+e+m;
	avg = total/3.0;
	}
	
	
	
	
	
void display() { //void - �޼ҵ� ���� ��ɵ��� �����ϰ� ������¶�. ���ϰ����ٴ� ��
	
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
		msg = msg + total;
		msg = msg + "\t";
		msg = msg + avg;
		msg = msg + "\n";
		msg = msg + "-----------------------------------------------\n";		
		System.out.println(msg);
		
		
	}
}

public class Time01 {
	
	
	
	
	public static void main(String[] args) {
		int a; //��� ���  �ʵ尡 �ƴ϶� �ڵ����� �ʱ�ȭ �������� �ʴ´�. 
		//������Ű������ ������ �̸��� Ŭ���� ������. 
		//�ڷ��� ���� = new ������(); �����ڴ� Ŭ���� �̸��� ������ �޼ҵ�
		Scanner sc = new Scanner(System.in);
		System.out.println("����: ");
		a = sc.nextInt();
		System.out.println("����: ");// TODO Auto-generated constructor stub
		int b = sc.nextInt();
		System.out.println("����: ");
		int c = sc.nextInt();
		
		
		Temp t1 = new Temp(a,b,c); //��ü�� ���� t1�� ��ƶ� . ��ü�� �����ϸ� �ڵ����� �ʱ�ȭ�ȴ�. 
								   // ��ü�� ���� ���� ���� �Է��ϴ� ����� �ְ�, �� �Է��� ���ϰ� �ް�
								   //������ �Է� �޼��带 ���� ����� ����� �ִ�. �׸���. ��ü �������� ���� �޼��忡��
									//�Է¹��� ���� �⺻������ �ܰ迡�� ��ü�� �����ִ� ������ִ�. 
									// �⺻ �����ڿ��� �Է� �޴� ����� �ִ�. 
		t1.display();
//		t1.kor = 90;
//		t1.eng = 80;
//		t1.mat = 70;
//		t1.total = t1.kor + t1.eng + t1.mat;
//		t1.avg = (double)t1.total / 3; //�ڵ�����ȯ.

		
		
//		Temp t2 = new Temp();
//		t2.kor = 99;
//		t2.eng = 88;
//		t2.mat = 77;
//		t2.total = t2.kor + t2.eng + t2.mat;
//		t2.avg = (double)t2.total/3;
//		t2.display();
		
		
		
	}

}
