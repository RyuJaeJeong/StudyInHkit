package exam04;

import java.util.Scanner;

public class TestT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name1 = sc.nextLine();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int kor1 = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int eng1 = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int mat1 = sc.nextInt();
		int total1 = kor1+eng1+mat1;
		double aver1 = total1/3.0;
		String grade1;
		if(aver1>=90) {
			grade1 = "��";
			
		}else if(aver1>=80) {
			grade1 = "��";
			
		}else if(aver1>=70) {
			grade1 = "��";
			
		}else if(aver1>=60) {
			grade1 = "��";
			
		}else {
			grade1 = "��";
		}
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name2 = sc.next();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int kor2 = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int eng2 = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int mat2 = sc.nextInt();
		sc.nextLine();
		int total2 = kor2+eng2+mat2;
		double aver2 = total2/3.0;
		String grade2;
		if(aver2>=90) {
			grade2 = "��";
			
		}else if(aver2>=80) {
			grade2 = "��";
			
		}else if(aver2>=70) {
			grade2 = "��";
			
		}else if(aver2>=60) {
			grade2 = "��";
			
		}else {
			grade2 = "��";
		}
		System.out.println(name2);
		System.out.println(grade2);
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name3 = sc.nextLine();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int kor3 = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int eng3 = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int mat3 = sc.nextInt();
		sc.nextLine();
		int total3 = kor3+eng3+mat3;
		double aver3 = total3/3.0;
		String grade3;
	
		if(aver3>=90) {
			grade3 = "��";
			
		}else if(aver3>=80) {
			grade3 = "��";
			
		}else if(aver3>=70) {
			grade3 = "��";
			
		}else if(aver3>=60) {
			grade3 = "��";
			
		}else {
			grade3 = "��";
		}
		
		
	 System.out.println("----------------------------------------------");
	 System.out.println("�̸�\t����\t����\t����\t����\t���\t���");
     System.out.println("----------------------------------------------");
	 System.out.println(name1+"\t"+kor1+"\t"+eng1+"\t"+mat1+"\t"+total1+"\t"+aver1+"\t"+grade1+"\n");	
	 System.out.println(name2+"\t"+kor2+"\t"+eng2+"\t"+mat2+"\t"+total2+"\t"+aver2+"\t"+grade2+"\n");
	 System.out.println(name3+"\t"+kor3+"\t"+eng3+"\t"+mat3+"\t"+total3+"\t"+aver3+"\t"+grade3+"\n");
	 System.out.println("----------------------------------------------");
		
	
	// for(i=1)
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
		
	
	}
}
