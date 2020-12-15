package exam06;

import java.util.Scanner;

public class ArrayExam2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String temp ="";
		String[] temps = new String[5];
		
		for(int i=0; i<=4; i++) {
			System.out.print("이름을 입력하여 주세요.");
			String name = sc.nextLine();
			System.out.println("국어 점수를 입력해주세요.");
			String lang = sc.nextLine();
			System.out.println("수학 점수를 입력해주세요.");
			String math = sc.nextLine();
			System.out.println("영어 점수를 입력해주세요.");
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
				grade = "수";
			}else if( aver>80.0) {
				grade = "우";
			}else if( aver>70.0) {
				grade = "0미";
			}else if(aver>60.0) {
				grade = "양";
			}else {
				grade = "가";
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
		System.out.println("이름\t국어\t수학\t영어\t총점\t평균");
		System.out.println("------------------------------------");
		for(int i=0; i<temps.length; i+=1 ) {
		
		System.out.print(temps[i]);
		}
		System.out.println("------------------------------------");
	
		
		

	}


		
}


