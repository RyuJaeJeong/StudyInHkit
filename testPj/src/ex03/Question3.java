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
			System.out.print("이름을 입력하세요 ");
			name = sc.nextLine();
			System.out.print("국어점수를 입력하세요 ");
			kor = sc.nextInt();
			System.out.print("영어점수를 입력하세요 ");
			eng = sc.nextInt();
			System.out.print("수학점수를 입력하세요 ");
			mat = sc.nextInt();
			sc.nextLine();
			tot = kor + eng + mat;
			ave = tot/3.0;
			temp = name+"|"+kor+"|"+eng+"|"+mat+"|"+tot+"|"+ave;
			arr[i] = temp;                                                                                                                 
			}
		System.out.println(); //가독성 개선을 위한 줄바꾸기. 
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		String [] brr = new String[6]; 
		for (int i = 0; i < arr.length; i++) {
			brr = arr[i].split("[|]");
			double imsi = Double.parseDouble(brr[5]);
			String total = String.format("%.2f", imsi); //소수점 둘째자리까지 표현. 
			System.out.println(brr[0]+"\t" + brr[1]+"\t" +brr[2]+"\t" +brr[3]+"\t" +brr[4]+"\t" + total);
		}
		
		System.out.println(" ----- 프로그램 종료-----");

	}

}
