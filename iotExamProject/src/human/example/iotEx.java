package human.example;



import java.util.ArrayList;
import java.util.Scanner;

import iot.Aircondition;
import iot.Elevator;
import iot.Light;
import iot.Security;
import iot.Tv;



public class iotEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아파트 아이디를 입력하세요 : ");
		String aptId = sc.nextLine();
		iot.remoteController r1;
		ArrayList<Boolean> arr = new ArrayList<>();
		ArrayList<String> brr = new ArrayList<>();
		int temp = 0;
		int nowFloor = 0;
		int stopFloor = 0;

		
		while(true) {
			
			System.out.print("선택하세요(1.Elevator 2.Security 3.Aircondition 4.Light 5.Tv  0.종료)");
			int select = sc.nextInt();
			sc.nextLine();
			
			boolean a = false;
			arr.add(a);
			boolean b = false;
			arr.add(b);
			boolean c = false;
			arr.add(c);
			boolean d = false;
			arr.add(d);
			boolean e = false;
			arr.add(e);
			
			
			
			
			if(select==1) {
				Elevator e1 = new Elevator(aptId);
				System.out.print("출발지를 입력해 주세요 : ");
				nowFloor = sc.nextInt();
				sc.nextLine();
				System.out.print("도착지를 입력해 주세요 : ");
				stopFloor = sc.nextInt();
				sc.nextLine();
				
				if(nowFloor>stopFloor) {
					 a = e1.goingDown(nowFloor, stopFloor);
					arr.add(0,a);
				}else if(nowFloor<stopFloor) {
					 a = e1.goingUp(nowFloor, stopFloor);
					arr.add(0,a);
				}else if(nowFloor==stopFloor) {
					 a = e1.goingNone(nowFloor, stopFloor);
					arr.add(0,a);
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
				
			}else if(select==2) {
				r1 = new Security(aptId);
				System.out.print("선택하세요.(1.켠다 2.끈다)");
				temp = sc.nextInt();
				if(temp==1) {
					b = r1.on();
					arr.add(1,b);
				}else if(temp==2) {
					b = r1.off();
					arr.add(1,b);
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}else if(select==3) {
				
				System.out.print("선택하세요.(1.켠다 2.끈다)");
				temp = sc.nextInt();
				
				if(temp==1) {
					r1 = new Aircondition(aptId);
					c = r1.on();
					arr.add(2,c);
				}else if(temp==2) {
					r1 = new Aircondition(aptId);
					c = r1.off();
					arr.add(2,c);
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}else if(select==4) {
				r1 = new Light(aptId);
				System.out.print("선택하세요.(1.켠다 2.끈다)");
				temp = sc.nextInt();
				if(temp==1) {
					d = r1.on();
					arr.add(3,d);
				}else if(temp==2) {
					d = r1.off();
					arr.add(3,d);
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}else if(select==5) {
				
				System.out.print("선택하세요.(1.켠다 2.끈다)");
				temp = sc.nextInt();
				
				if(temp==1) {
					sc.nextLine();
					r1 = new Tv(aptId);
					e = r1.on();
					arr.add(4,e);
				}else if(temp==2) {
					r1 = new Tv(aptId);
					e = r1.off();
					arr.add(4,e);
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
			else if(select==0) {
				
				brr.add(0, aptId);
				
				a=arr.get(0);
				
				if(a==true) {
					
					System.out.println("현재 엘리베이터는 "+stopFloor+"층에 있습니다.");
				}else {
					System.out.println("엘리베이터가 동작하지 않았습니다.");
				}
				b=arr.get(1);
				if(b==true) {
					brr.add(1, "On");
					System.out.println("현재 현관문이 열려있습니다.");
				}else {
					brr.add(1, "Off");
					System.out.println("현재 현관문은 잠겨있습니다.");
				}
				c=arr.get(2);
				if(c==true) {
					brr.add(2, "On");
					System.out.println("현재 에어컨의 설정온도는 입니다.");
				}else {
					brr.add(2, "Off");
					System.out.println("에어컨이 꺼져있습니다.");
				}
				d=arr.get(3);
				if(d==true) {
					brr.add(3, "On");
					System.out.println("현재 전등이 켜져있습니다.");
				}else {
					brr.add(3, "Off");
					System.out.println("현재 전등이 꺼져있습니다.");
				}
				e=arr.get(4);
				if(e==true) {
					brr.add(4, "ON");
					System.out.println("현재 tv는 켜져있습니다.");
				}else {
					brr.add(4, "OFF");
					System.out.println("현재 tv가 꺼져있습니다.");
				}
				
				
				break;
			}else {
				continue;
			}
		}	
			System.out.println("--프로그램 종료--");
			
		
			
	}

}
