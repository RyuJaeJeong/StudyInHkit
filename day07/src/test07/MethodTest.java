package test07;

import java.util.Scanner;

public class MethodTest {
	
	//���������� ��ȯ�� �޼ҵ��()
	//�޼ҵ�� ��ü�����δ� ������ �ȵȴ�.
	//�������� ȣ���� �ؾ߸� ������ �ȴ�.
	static void insa() {
		System.out.println("ȫ�浿");
		System.out.println("�ȳ��ϼ���?");
	}
	
	static void insa2(String name) { //�Ķ���� 
		
		System.out.println(name +"�� �ȳ��ϼ���?");
	}
	
	static void insa3(int kor, int eng, int mat) { //�Ķ���� 
		int total = kor + eng + mat;
		System.out.println("������" + total +"�Դϴ�.");
	}
	
	static void qqt(int dan) { //�Ķ���� 
		for (int j=1; j<10; j++) {
			System.out.printf("%d * %d = %d\n", dan, j, dan*j);
		}
	}
	
	
	public static void main(String[] args) {
		
//			insa(); //ȣ��
//			insa2("������");
//			insa3(90, 80, 70);
//			insa3(50, 60, 70);//�ƱԸ�Ʈ
//			 for(int dan=2; dan<10; dan++) {
//				qqt(dan);
//			}
			//�ް�����, ����, �Ķ����, �ƱԸ�Ʈ
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		int dan = sc.nextInt();
		qqt(dan);
	}
}
