package exam03;

import java.util.Scanner;

public class Test04 { public static void main(String[] args) {
	
	
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("이름을 입력하세요 : ");
	String name = sc.next();
	sc.nextLine();
	System.out.print("당신의 주민등록번호 앞자리를 입력하세요. : ");
	String frontident = sc.nextLine();
	
    System.out.print("당신의 주민등록번호 뒷자리를 입력하세요 : ");
    String backident = sc.nextLine();
    
   
    String backident1 = backident.substring(0,1); //주민번호 뒷 자리의 첫째자리. 성별 판별용
    int frontident2 = Integer.parseInt(frontident.substring(0,2)); //주민번호 앞자리의 두자리, 나이 계산용.
    
    System.out.printf("당신의 이름은 %s입니다.\n",name);
	System.out.printf("당신의 주민등록 번호는 %s - %s 입니다.\n", frontident, backident);
	if(backident1.equals("1") || backident1.equals("3")) {       //backident1 을 이용한 성별 판별.
		System.out.println("당신은 남자입니다");
	}else {
		System.out.println("당신은 여자입니다.");
	}
	
	
	int age;
	
	if(backident1.equals("1") || backident1.equals("2")) {  //frontident1을 이용한 나이 계산. 
		age = 2020 - (1900+frontident2)+1;
	}else {
		age = 20 - frontident2+1;
	}
	System.out.printf("당신의 나이는 %d입니다.",age);
	
	
	
	
	//substring, 조건문,  parseInt 
	
	





}	



}
	
	
	
	
	
	
	
	
	










