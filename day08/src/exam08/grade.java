package exam08;

import java.util.Scanner;

public class grade {

	String name;
	int kor;
	int math;
	int eng;
	
	    void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��� �ּ���.");
		name = sc.nextLine();
		sc.nextLine();
		System.out.println("���������� �Է��ϼ���.");
		kor = sc.nextInt();
		System.out.println("���������� �Է��ϼ���.");
		math =sc.nextInt();
		System.out.println("���������� �Է��ϼ���.");
		eng = sc.nextInt();
		
	}
	    
	 void display() {
		System.out.println(name+"\t"+kor+"\t"+math+"\t"+eng);
	}
	
	
	public static void main(String[] args) {
	
	grade stu1 = new grade();
	stu1.input();
	stu1.display();
	grade stu2 = new grade();
	stu2.input();
	stu2.display();
	grade stu3 = new grade();
	stu3.input();
	stu3.display();
	
	
	
	}

}
