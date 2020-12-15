package exam03;

import java.util.Scanner;

public class Test041 {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);

 System.out.println("당신의 이름을 입력하세요 : ");
 String name = sc.nextLine();
 System.out.println("당신의 주민등록 번호를 입력해 주세요 : ");
 String id = sc.nextLine();	

 int genId = Integer.parseInt(id.substring(6,7));
 int ageId = Integer.parseInt(id.substring(0,2)); 

 String msg = "";
 msg = msg + "당신의 이름은 ";
 msg = msg + name;
 msg = msg + "입니다.\n";
 msg = msg +"당신의 주민등록 번호는 ";
 msg = msg + id.substring(0,6);
 msg = msg + " - ";
 msg = msg + id.substring(6);
 msg = msg + "입니다.\n";
 
 
 String sex;
 
 if (genId == 1 || genId == 3) {
	 sex = "남자";
 }else {
	sex = "여자";
 }
 int age;
 if (genId==1||genId==2) {
	 age = 2020 - (ageId+1900) +1;
 } else {
	 age = 20 - ageId;
 }
 
 msg = msg + "당신은 ";
 msg = msg + sex;
 msg = msg + "입니다.\n";		 
 msg = msg + "당신의 나이는";
 msg = msg + age;
 msg = msg + "세입니다.";
 
 System.out.println(msg);
 
 
 
 
 
 
 
 
 
 
	
	}

}
