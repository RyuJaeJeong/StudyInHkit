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
		
		map1.put("�̸�", "����");
		map1.put("����", "2500");
		map1.put("����", "20");
		
		map2.put("�̸�", "����");
		map2.put("����", "1500");
		map2.put("����", "20");
		
		map3.put("�̸�", "���ɸ�");
		map3.put("����", "2000");
		map3.put("����", "10");
		
		arr[0] = map1;
		arr[1] = map2;
		arr[2] = map3;
		
		/*for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}*/
		double tot = 0;
		while(true) {
			System.out.println("�����ϼ���(0:����, 1:����, 2:����)");
			int temp = sc.nextInt();
			sc.nextLine();
			if (temp==0) {
				break;
			}else if(temp==1) {
				for (int i = 0; i < brr.size(); i++) {
					System.out.println(brr.get(i));
					double cou =Integer.parseInt(brr.get(i).get("����"))*0.01; 
					tot = tot +Integer.parseInt(brr.get(i).get("����"))*(1-cou);
				}
				System.out.println("����"+"\t\t"+tot);
			}else if(temp==2) {
			System.out.println("�ε����� �Է��ϼ���(0:����, 1:����, 2:���ɸ�)");
			brr.add(arr[sc.nextInt()]);
			}
			else {
				continue;
			}
			
		}
		System.out.println("--���α׷� ����--");
		
	}

}
