package exam06;

import java.util.Scanner;

public class ArrayExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name[] = new String[5];
		int[] lang = new int[5];
		int[] math = new int[5];
		int[] eng = new int[5];
		int[] total = new int[5];
		double[] aver = new double[5];
		String grade[] = new String[5];
		
		for(int i=0; i<=4; i++) {
			System.out.print("�̸��� �Է��Ͽ� �ּ���.");
			name[i] = sc.nextLine();
			System.out.println("���� ������ �Է����ּ���.");
			lang[i] = sc.nextInt();
			System.out.println("���� ������ �Է����ּ���.");
			math[i] = sc.nextInt();
			System.out.println("���� ������ �Է����ּ���.");
			eng[i] = sc.nextInt();
			sc.nextLine();
			total[i] = lang[i]+math[i]+eng[i];
			aver[i] = total[i]/3.0;
			if( aver[i]>90.0) {
				grade[i] = "��";
			}else if( aver[i]>80.0) {
				grade[i] = "��";
			}else if( aver[i]>70.0) {
				grade[i] = "��";
			}else if(aver[i]>60.0) {
				grade[i] = "��";
			}else {
				grade[i] = "��";
			}
		}
		System.out.println("------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		System.out.println("------------------------------------");
		for(int i=0; i<=4; i+=1 ) {
		
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n",name[i],lang[i],math[i],eng[i],total[i],aver[i],grade[i]);
		
		}
		System.out.println("------------------------------------");
		
	}

}
