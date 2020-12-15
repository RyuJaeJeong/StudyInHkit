package ex04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> arr = new ArrayList<>();
			while(true) {
			System.out.print("선택하세요(1.조회  2.입력   3.종료) ");
			int temp = sc.nextInt();
			sc.nextLine();
				   if(temp == 1) {								//1을 입력하면 리스트에 저장된 객체들의 display를 실행. 
						if(arr.size() == 0) {
							System.out.println("----현재 입력된 값이 없습니다.----");
						}else {
							System.out.println("이름" +"\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t" + "평균");
							for (int i = 0; i < arr.size(); i++) {
							arr.get(i).display(); 
						    }
						}
					} else if(temp == 2) {						//2를 입력하면 객체를 생성해서 필드를 입력하고. 그값을 리스트에 저장한다.
					System.out.print("이름을 입력해 주세요. ");
					String name = sc.nextLine();
					System.out.print("국어점수를 입력해 주세요. ");
					int kor = sc.nextInt();
					System.out.print("영어점수를 입력해 주세요. ");
					int eng = sc.nextInt();
					System.out.print("수학점수를 입력해 주세요. ");
					int mat = sc.nextInt();
					arr.add(new Student(name, kor, eng, mat));
					}else if(temp == 3) {                      //3을 입력하면 프로그램 종료
					break;
					}else {
					continue;								  //그외를 입력하면 프로그램 초기화면으로. 
					}
			}

	}

}
