package Time01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RecordUse {

	public static void main(String[] args) throws IOException {
		ArrayList<HashMap<String, String>> arr = new ArrayList<>();
		while(true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�̸��� �Է��� �ּ���? :  ");
			String name = in.readLine();
			if(name.toLowerCase().equals("q")) break;
			System.out.print("���� ������ �Է��� �ּ���? :  ");
			String kor = in.readLine();
			System.out.print("���� ������ �Է��� �ּ���? :  ");
			String eng = in.readLine();
			System.out.print("���� ������ �Է��� �ּ���? :  ");
			String mat = in.readLine();
			
			int total = Integer.parseInt(kor) + Integer.parseInt(eng) +Integer.parseInt(mat);
			double aver = total/3.;
			String tot = Integer.toString(total);
			String avg =  Double.toString(aver);
			
			HashMap<String, String> map = new HashMap<>();
			map.put("�̸�", name);
			map.put("����", kor);
			map.put("����", eng);
			map.put("����", mat);
			map.put("�հ�", tot);
			map.put("���", avg);
			
			arr.add(map);
			}
		
		for (int i = 0; i < arr.size(); i++) {
		HashMap<String, String> map = arr.get(i);
		System.out.print(map.get("�̸�") + "/");
		System.out.print(map.get("����") + "/");
		System.out.print(map.get("����") + "/");
		System.out.print(map.get("����") + "/");
		System.out.print(map.get("�հ�") + "/");
		System.out.println(map.get("���") + "/");
		}
	
	
	
	
	}

}
