package exam05;

import java.util.Scanner;

public class testT {
	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			String name = "";
			int kor = 0;
			int eng = 0;
			int mat = 0;
			int total = 0;
			int aver = 0;
			String grade = "";
			
			for (int i=1; i<=3; i++) {
			
			System.out.print("이름을 입력하세요 : ");
			name = sc.nextLine();
			sc.nextLine();
			System.out.print("국어 점수를 입력하세요 : ");
			 kor = sc.nextInt();
			sc.nextLine();
			System.out.print("영어 점수를 입력하세요 : ");
			 eng = sc.nextInt();
			sc.nextLine();
			System.out.print("수학 점수를 입력하세요 : ");
			 mat = sc.nextInt();
			 total = kor + eng + mat;
			 aver = total/3;
			
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
			System.out.print(name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+total+"\t"+aver+"\t"+grade);
			}
			
				}
			}
	
	
	}
//}
			


