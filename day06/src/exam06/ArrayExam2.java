package exam06;

import java.util.Scanner;

public class ArrayExam2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String temp ="";
		String[] temps = new String[5];
		
		for(int i=0; i<=4; i++) {
			System.out.print("�̸��� �Է��Ͽ� �ּ���.");
			String name = sc.nextLine();
			System.out.println("���� ������ �Է����ּ���.");
			String lang = sc.nextLine();
			System.out.println("���� ������ �Է����ּ���.");
			String math = sc.nextLine();
			System.out.println("���� ������ �Է����ּ���.");
			String eng = sc.nextLine();
			sc.nextLine();
			int lang2 = Integer.parseInt(lang);
			int math2 = Integer.parseInt(math);
			int eng2 = Integer.parseInt(eng);
			int total = lang2 + math2 + eng2;
			double aver;
			aver = total/3.0;
			String grade = "";
			if( aver>90.0) {
				grade = "��";
			}else if( aver>80.0) {
				grade = "��";
			}else if( aver>70.0) {
				grade = "0��";
			}else if(aver>60.0) {
				grade = "��";
			}else {
				grade = "��";
			}
			
			
			temp += name+"\t,";
			temp += lang+"\t,";
			temp += math+"\t,";
			temp += eng+"\t,";
			temp += total+"\t,";
			temp += aver+"\t,";
			temp += grade+"\t,\n";
			temps = temp.split(",");
		}
		
//		System.out.println("------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		System.out.println("------------------------------------");
		for(int i=0; i<temps.length; i+=1 ) {
		
		System.out.print(temps[i]);
		}
		System.out.println("------------------------------------");
	
		
		

	}


		
}


