package test07;

import java.util.ArrayList;
import java.util.Scanner;

public class ListGrade {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ArrayList grade = new ArrayList();
	String [] subject = {"����","����","����", "����", "����", "ü��", "����", "�̼�"};
	for (int i = 0; i < subject.length; i++) {
		System.out.println(subject[i] + "������ �Է��ϼ���");
		grade.add(sc.nextInt());
		
	}
	
	
	
	
	
	
//	System.out.print("���� ������ �Է��ϼ��� : ");
//	grade.add(sc.nextInt());
//	System.out.print("���� ������ �Է��ϼ��� : ");
//	grade.add(sc.nextInt());
//	System.out.print("���� ������ �Է��ϼ��� : ");
//	grade.add(sc.nextInt());
//	System.out.print("���� ������ �Է��ϼ��� : ");
//	grade.add(sc.nextInt());
//	System.out.print("���� ������ �Է��ϼ��� : ");
//	grade.add(sc.nextInt());
//	System.out.print("ü�� ������ �Է��ϼ��� : ");
//	grade.add(sc.nextInt());
//	System.out.print("���� ������ �Է��ϼ��� : ");
//	grade.add(sc.nextInt());
//	System.out.print("�̼� ������ �Է��ϼ��� : ");
//	grade.add(sc.nextInt());
	
	int total = 0;
	int average = 0;
	
	for(int i=0; i<grade.size(); i++) {
		 total = total + (int) grade.get(i);
	}
	
	average = total/grade.size();
	
	//���
	
	System.out.println("����  ����  ����  ����  ����  ü��  ����  �̼�  ����  ���");
	
	for(int i=0; i<grade.size(); i++) {
		System.out.print((int)grade.get(i)+"  ");
	}
	
	System.out.print(total+" "+average);
		
		
		
		}
	
	
	}


