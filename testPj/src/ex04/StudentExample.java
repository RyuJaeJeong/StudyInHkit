package ex04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> arr = new ArrayList<>();
			while(true) {
			System.out.print("�����ϼ���(1.��ȸ  2.�Է�   3.����) ");
			int temp = sc.nextInt();
			sc.nextLine();
				   if(temp == 1) {								//1�� �Է��ϸ� ����Ʈ�� ����� ��ü���� display�� ����. 
						if(arr.size() == 0) {
							System.out.println("----���� �Էµ� ���� �����ϴ�.----");
						}else {
							System.out.println("�̸�" +"\t" + "����" + "\t" + "����" + "\t" + "����" + "\t" + "����" + "\t" + "���");
							for (int i = 0; i < arr.size(); i++) {
							arr.get(i).display(); 
						    }
						}
					} else if(temp == 2) {						//2�� �Է��ϸ� ��ü�� �����ؼ� �ʵ带 �Է��ϰ�. �װ��� ����Ʈ�� �����Ѵ�.
					System.out.print("�̸��� �Է��� �ּ���. ");
					String name = sc.nextLine();
					System.out.print("���������� �Է��� �ּ���. ");
					int kor = sc.nextInt();
					System.out.print("���������� �Է��� �ּ���. ");
					int eng = sc.nextInt();
					System.out.print("���������� �Է��� �ּ���. ");
					int mat = sc.nextInt();
					arr.add(new Student(name, kor, eng, mat));
					}else if(temp == 3) {                      //3�� �Է��ϸ� ���α׷� ����
					break;
					}else {
					continue;								  //�׿ܸ� �Է��ϸ� ���α׷� �ʱ�ȭ������. 
					}
			}

	}

}
