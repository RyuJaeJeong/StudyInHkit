package day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) {
		HashMap<String, String> map1 = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>();
		HashMap<String, String> map3 = new HashMap<>();
		
		HashMap<String, String> [] arr = new HashMap[3];
		Scanner sc = new Scanner(System.in);
		ArrayList<HashMap<String, String>> brr = new ArrayList<HashMap<String, String>>();
		
		map1.put("이름", "맥주");
		map1.put("가격", "2500");
		map1.put("할인", "20");
		
		map2.put("이름", "소주");
		map2.put("가격", "1500");
		map2.put("할인", "20");
		
		map3.put("이름", "막걸리");
		map3.put("가격", "2000");
		map3.put("할인", "10");
		
		arr[0] = map1;
		arr[1] = map2;
		arr[2] = map3;
		
		/*for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}*/
		double tot = 0;
		while(true) {
			System.out.println("선택하세요(0:종료, 1:결제, 2:구매)");
			int temp = sc.nextInt();
			sc.nextLine();
			if (temp==0) {
				break;
			}else if(temp==1) {
				for (int i = 0; i < brr.size(); i++) {
					System.out.println(brr.get(i));
					double cou =Integer.parseInt(brr.get(i).get("할인"))*0.01; 
					tot = tot +Integer.parseInt(brr.get(i).get("가격"))*(1-cou);
				}
				System.out.println("총합"+"\t\t"+tot);
			}else if(temp==2) {
			System.out.println("인덱스를 입력하세요(0:맥주, 1:소주, 2:막걸리)");
			brr.add(arr[sc.nextInt()]);
			}
			else {
				continue;
			}
			
		}
		System.out.println("--프로그램 종료--");
		
	}

}
