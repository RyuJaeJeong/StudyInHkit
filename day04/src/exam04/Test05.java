package exam04;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("�̸��� �Է��ϼ��� : ");
	String name = sc.nextLine();
	
	System.out.print("�ټӿ����� �Է��ϼ��� : "  );
	int year = sc.nextInt();
	int hol;
	
		if (year>=1 && year<=3) {
			 hol = 5;
		} else if(year>=4 && year<=6) {
			 hol = 10;
		} else if(year>=7 && year<=8) {
			 hol = 20;
		} else if(year>=9 && year<=14) {
			 hol = 30;
		} else if(year>=15) {
			 hol = 50;
		} else { hol = 0;
		
		}
		
		String msg ="";
		msg = msg + name;
		msg = msg + "���� �ټӿ����� ";
		msg = msg + year;
		msg = msg + "���Դϴ�.";
		msg = msg + "\n�ް� �ϼ���";
	    msg = msg + hol;
	    msg = msg + "�� �Դϴ�.";
	
	System.out.println(msg);
	
	sc.close();
	
	}
}
