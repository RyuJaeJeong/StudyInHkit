package exam03;

import java.util.Scanner;

public class Test05 {


public static void main(String[] args) {
	
	
	Scanner sc = new Scanner(System.in);
		
	System.out.print("�̸�? ");
	String name = sc.nextLine();
	System.out.print("����? ");
	int lang = sc.nextInt();
	sc.nextLine();
	System.out.print("����? ");
	int math = sc.nextInt();
	sc.nextLine();
	System.out.print("����? ");
	int eng = sc.nextInt();
	sc.nextLine();
	
		int total = lang + math + eng;
	
		double aver = (double)total/3;
			
		//�� 90�̻� �� 80�̻� �� 70�� �̻� �� 60�̻� �� ������ 
		
		String grade;
		
		
		
		if(aver>=90) {
			grade = "��";
			
		}else if(aver>=80) {
			grade = "��";
			
		}else if(aver>=70) {
			grade = "��";
			
		}else if(aver>=60) {
			grade = "��";
			
		}else {
			grade = "��";
		}
		
		
		
		
		 String msg = "";
	      msg = msg + "===========================================================\n";
	      msg = msg + "�̸�\t";
	      msg = msg + "����\t";	  
	      msg = msg + "����\t";
	      msg = msg + "����\t";
	      msg = msg + "����\t";
	      msg = msg + "���\t";
	      msg = msg + "���\t\n";
	      msg = msg + "==========================================================\n";
	      msg = msg + name;
	      msg = msg + "\t";
	      msg = msg + lang;
	      msg = msg + "��\t";
	      msg = msg + math; 
	      msg = msg + "��\t";
	      msg = msg + eng;
	      msg = msg + "��\t";
	      msg = msg + total;
	      msg = msg + "��\t";
	      msg = msg + aver;
	      msg = msg + "��\t";
	      msg = msg + grade;
	      
	      msg = msg + "\n========================================================\n";
	      
	      System.out.println(msg);
	      
		
		
		
		
		
		
		
			}









}
