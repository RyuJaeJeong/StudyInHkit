package ex03;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] arr = new String[3];
		String name;
		int kor;
		int eng;
		int mat;
		int tot;
		double ave;
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			System.out.print("�̸��� �Է��ϼ��� ");
			name = sc.nextLine();
			System.out.print("���������� �Է��ϼ��� ");
			kor = sc.nextInt();
			System.out.print("���������� �Է��ϼ��� ");
			eng = sc.nextInt();
			System.out.print("���������� �Է��ϼ��� ");
			mat = sc.nextInt();
			sc.nextLine();
			tot = kor + eng + mat;
			ave = tot/3.0;
			temp = name+"|"+kor+"|"+eng+"|"+mat+"|"+tot+"|"+ave;
			arr[i] = temp;                                                                                                                 
			}
		System.out.println(); //������ ������ ���� �ٹٲٱ�. 
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		String [] brr = new String[6]; 
		for (int i = 0; i < arr.length; i++) {
			brr = arr[i].split("[|]");
			double imsi = Double.parseDouble(brr[5]);
			String total = String.format("%.2f", imsi); //�Ҽ��� ��°�ڸ����� ǥ��. 
			System.out.println(brr[0]+"\t" + brr[1]+"\t" +brr[2]+"\t" +brr[3]+"\t" +brr[4]+"\t" + total);
		}
		
		System.out.println(" ----- ���α׷� ����-----");

	}

}
