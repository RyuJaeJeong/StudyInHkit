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
			System.out.print("이름을 입력하여 주세요.");
			name[i] = sc.nextLine();
			System.out.println("국어 점수를 입력해주세요.");
			lang[i] = sc.nextInt();
			System.out.println("수학 점수를 입력해주세요.");
			math[i] = sc.nextInt();
			System.out.println("영어 점수를 입력해주세요.");
			eng[i] = sc.nextInt();
			sc.nextLine();
			total[i] = lang[i]+math[i]+eng[i];
			aver[i] = total[i]/3.0;
			if( aver[i]>90.0) {
				grade[i] = "수";
			}else if( aver[i]>80.0) {
				grade[i] = "우";
			}else if( aver[i]>70.0) {
				grade[i] = "미";
			}else if(aver[i]>60.0) {
				grade[i] = "양";
			}else {
				grade[i] = "가";
			}
		}
		System.out.println("------------------------------------");
		System.out.println("이름\t국어\t수학\t영어\t총점\t평균");
		System.out.println("------------------------------------");
		for(int i=0; i<=4; i+=1 ) {
		
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n",name[i],lang[i],math[i],eng[i],total[i],aver[i],grade[i]);
		
		}
		System.out.println("------------------------------------");
		
	}

}
