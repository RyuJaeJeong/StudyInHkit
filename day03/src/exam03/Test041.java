package exam03;

import java.util.Scanner;

public class Test041 {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);

 System.out.println("����� �̸��� �Է��ϼ��� : ");
 String name = sc.nextLine();
 System.out.println("����� �ֹε�� ��ȣ�� �Է��� �ּ��� : ");
 String id = sc.nextLine();	

 int genId = Integer.parseInt(id.substring(6,7));
 int ageId = Integer.parseInt(id.substring(0,2)); 

 String msg = "";
 msg = msg + "����� �̸��� ";
 msg = msg + name;
 msg = msg + "�Դϴ�.\n";
 msg = msg +"����� �ֹε�� ��ȣ�� ";
 msg = msg + id.substring(0,6);
 msg = msg + " - ";
 msg = msg + id.substring(6);
 msg = msg + "�Դϴ�.\n";
 
 
 String sex;
 
 if (genId == 1 || genId == 3) {
	 sex = "����";
 }else {
	sex = "����";
 }
 int age;
 if (genId==1||genId==2) {
	 age = 2020 - (ageId+1900) +1;
 } else {
	 age = 20 - ageId;
 }
 
 msg = msg + "����� ";
 msg = msg + sex;
 msg = msg + "�Դϴ�.\n";		 
 msg = msg + "����� ���̴�";
 msg = msg + age;
 msg = msg + "���Դϴ�.";
 
 System.out.println(msg);
 
 
 
 
 
 
 
 
 
 
	
	}

}
