package Test09;

import java.util.Scanner;

public class Time07 {


	
	public Time07() {
		// TODO Auto-generated constructor stub
	}


	void drink(int a) {
		if(a>=20) {
			System.out.println("���� ���Ǽ� �ֽ��ϴ�.");
		}else {System.out.println("���� ���Ǽ� �����ϴ�.");
		}
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ���̴�? : ");
		int a = sc.nextInt();
		Time07 t1 = new Time07();
		t1.drink(a);
		
		
	
	
	
	
	}

}
