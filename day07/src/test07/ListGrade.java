package test07;

import java.util.ArrayList;
import java.util.Scanner;

public class ListGrade {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ArrayList grade = new ArrayList();
	String [] subject = {"국어","영어","수학", "과학", "역사", "체육", "음악", "미술"};
	for (int i = 0; i < subject.length; i++) {
		System.out.println(subject[i] + "점수를 입력하세요");
		grade.add(sc.nextInt());
		
	}
	
	
	
	
	
	
//	System.out.print("국어 점수를 입력하세요 : ");
//	grade.add(sc.nextInt());
//	System.out.print("영어 점수를 입력하세요 : ");
//	grade.add(sc.nextInt());
//	System.out.print("수학 점수를 입력하세요 : ");
//	grade.add(sc.nextInt());
//	System.out.print("과학 점수를 입력하세요 : ");
//	grade.add(sc.nextInt());
//	System.out.print("역사 점수를 입력하세요 : ");
//	grade.add(sc.nextInt());
//	System.out.print("체육 점수를 입력하세요 : ");
//	grade.add(sc.nextInt());
//	System.out.print("음악 점수를 입력하세요 : ");
//	grade.add(sc.nextInt());
//	System.out.print("미술 점수를 입력하세요 : ");
//	grade.add(sc.nextInt());
	
	int total = 0;
	int average = 0;
	
	for(int i=0; i<grade.size(); i++) {
		 total = total + (int) grade.get(i);
	}
	
	average = total/grade.size();
	
	//출력
	
	System.out.println("국어  영어  수학  과학  역사  체육  음악  미술  총점  평균");
	
	for(int i=0; i<grade.size(); i++) {
		System.out.print((int)grade.get(i)+"  ");
	}
	
	System.out.print(total+" "+average);
		
		
		
		}
	
	
	}


