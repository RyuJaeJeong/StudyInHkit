package exam03;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in); //Ű����� �Է¹޴� ���α׷�
	//System.out.print("���ڸ� �Է��ϼ��� : ");
    //int num1 = scanner.nextInt(); //���ڸ� �Է¹޴´�.
    //System.out.println(num1);
		
//	System.out.print("�ּҸ� �Է��ϼ��� : ");	
//	String address = scanner.next(); //ù��° ���� �տ������� �ν��� ���ش�. 
//	scanner.nextLine(); //Ű���� ���۸� ���� ��Ȱ�� �Ѵ�. 
//	System.out.print("�̸��� �Է��ϼ��� : ");
//	String name = scanner.nextLine(); //��ü ������ �ν��Ѵ�.
//	System.out.println(address);
//	System.out.println(name);

		
		//Ű���� �Է� -> Ű������� -> num1
		//next() : ���ڿ��� �Է� �޴µ�, �پ�� �������� �Է¹޴´�.
	    //nextLine() : ���ڿ��� �Է¹޴µ�, �� �� ��ü�� �Է¹޴´�. nextLine()�޼ҵ�� Ű���� ���۰� ��������� �Է��� �䱸������, ������������� ������ ��ü������ �о�´�. 
		
		
System.out.print("���ڸ� �Է��ϼ��� : ");		
int num1 = scanner.nextInt();

scanner.nextLine();

System.out.println("�ּҸ� �Է��ϼ��� : ");
String address = scanner.nextLine();

System.out.println(num1);
System.out.println(address);


		
		
		
		
		
	}
	
	
	
}
