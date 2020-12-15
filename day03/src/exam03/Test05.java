package exam03;

import java.util.Scanner;

public class Test05 {


public static void main(String[] args) {
	
	
	Scanner sc = new Scanner(System.in);
		
	System.out.print("이름? ");
	String name = sc.nextLine();
	System.out.print("국어? ");
	int lang = sc.nextInt();
	sc.nextLine();
	System.out.print("수학? ");
	int math = sc.nextInt();
	sc.nextLine();
	System.out.print("영어? ");
	int eng = sc.nextInt();
	sc.nextLine();
	
		int total = lang + math + eng;
	
		double aver = (double)total/3;
			
		//수 90이상 우 80이상 미 70점 이상 양 60이상 가 나머지 
		
		String grade;
		
		
		
		if(aver>=90) {
			grade = "수";
			
		}else if(aver>=80) {
			grade = "우";
			
		}else if(aver>=70) {
			grade = "미";
			
		}else if(aver>=60) {
			grade = "양";
			
		}else {
			grade = "가";
		}
		
		
		
		
		 String msg = "";
	      msg = msg + "===========================================================\n";
	      msg = msg + "이름\t";
	      msg = msg + "국어\t";	  
	      msg = msg + "수학\t";
	      msg = msg + "영어\t";
	      msg = msg + "총점\t";
	      msg = msg + "평균\t";
	      msg = msg + "등급\t\n";
	      msg = msg + "==========================================================\n";
	      msg = msg + name;
	      msg = msg + "\t";
	      msg = msg + lang;
	      msg = msg + "점\t";
	      msg = msg + math; 
	      msg = msg + "점\t";
	      msg = msg + eng;
	      msg = msg + "점\t";
	      msg = msg + total;
	      msg = msg + "점\t";
	      msg = msg + aver;
	      msg = msg + "점\t";
	      msg = msg + grade;
	      
	      msg = msg + "\n========================================================\n";
	      
	      System.out.println(msg);
	      
		
		
		
		
		
		
		
			}









}
