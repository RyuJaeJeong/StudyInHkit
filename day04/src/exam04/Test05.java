package exam04;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("이름을 입력하세요 : ");
	String name = sc.nextLine();
	
	System.out.print("근속연수를 입력하세요 : "  );
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
		msg = msg + "님의 근속연수는 ";
		msg = msg + year;
		msg = msg + "년입니다.";
		msg = msg + "\n휴가 일수는";
	    msg = msg + hol;
	    msg = msg + "일 입니다.";
	
	System.out.println(msg);
	
	sc.close();
	
	}
}
