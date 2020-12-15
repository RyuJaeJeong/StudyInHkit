package day16;


import java.util.ArrayList;
import java.util.Scanner;

public class Package {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();
		while(true) {
			System.out.print("선택하세요(0:종료, 1:배송, 2:등록)");
			int temp = sc.nextInt();
			sc.nextLine();
			if(temp==0) {
				break;
			}else if(temp==1) {
				System.out.println(arr.get(arr.size()-1));
				arr.remove(arr.get(arr.size()-1));
			}else if(temp==2) {
				System.out.print("입고");
				arr.add(sc.nextLine());
				
			}
		}
	}

}
