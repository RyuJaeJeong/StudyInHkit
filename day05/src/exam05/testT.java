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
			
			System.out.print("�̸��� �Է��ϼ��� : ");
			name = sc.nextLine();
			sc.nextLine();
			System.out.print("���� ������ �Է��ϼ��� : ");
			 kor = sc.nextInt();
			sc.nextLine();
			System.out.print("���� ������ �Է��ϼ��� : ");
			 eng = sc.nextInt();
			sc.nextLine();
			System.out.print("���� ������ �Է��ϼ��� : ");
			 mat = sc.nextInt();
			 total = kor + eng + mat;
			 aver = total/3;
			
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
			System.out.print(name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+total+"\t"+aver+"\t"+grade);
			}
			
				}
			}
	
	
	}
//}
			


