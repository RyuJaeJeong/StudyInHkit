package exam03;

import java.util.Scanner;

public class Test04 { public static void main(String[] args) {
	
	
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("�̸��� �Է��ϼ��� : ");
	String name = sc.next();
	sc.nextLine();
	System.out.print("����� �ֹε�Ϲ�ȣ ���ڸ��� �Է��ϼ���. : ");
	String frontident = sc.nextLine();
	
    System.out.print("����� �ֹε�Ϲ�ȣ ���ڸ��� �Է��ϼ��� : ");
    String backident = sc.nextLine();
    
   
    String backident1 = backident.substring(0,1); //�ֹι�ȣ �� �ڸ��� ù°�ڸ�. ���� �Ǻ���
    int frontident2 = Integer.parseInt(frontident.substring(0,2)); //�ֹι�ȣ ���ڸ��� ���ڸ�, ���� ����.
    
    System.out.printf("����� �̸��� %s�Դϴ�.\n",name);
	System.out.printf("����� �ֹε�� ��ȣ�� %s - %s �Դϴ�.\n", frontident, backident);
	if(backident1.equals("1") || backident1.equals("3")) {       //backident1 �� �̿��� ���� �Ǻ�.
		System.out.println("����� �����Դϴ�");
	}else {
		System.out.println("����� �����Դϴ�.");
	}
	
	
	int age;
	
	if(backident1.equals("1") || backident1.equals("2")) {  //frontident1�� �̿��� ���� ���. 
		age = 2020 - (1900+frontident2)+1;
	}else {
		age = 20 - frontident2+1;
	}
	System.out.printf("����� ���̴� %d�Դϴ�.",age);
	
	
	
	
	//substring, ���ǹ�,  parseInt 
	
	





}	



}
	
	
	
	
	
	
	
	
	










