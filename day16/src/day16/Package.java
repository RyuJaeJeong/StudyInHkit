package day16;


import java.util.ArrayList;
import java.util.Scanner;

public class Package {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();
		while(true) {
			System.out.print("�����ϼ���(0:����, 1:���, 2:���)");
			int temp = sc.nextInt();
			sc.nextLine();
			if(temp==0) {
				break;
			}else if(temp==1) {
				System.out.println(arr.get(arr.size()-1));
				arr.remove(arr.get(arr.size()-1));
			}else if(temp==2) {
				System.out.print("�԰�");
				arr.add(sc.nextLine());
				
			}
		}
	}

}
