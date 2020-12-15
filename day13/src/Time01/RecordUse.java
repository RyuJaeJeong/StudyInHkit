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
			System.out.println("이름을 입력해 주세요? :  ");
			String name = in.readLine();
			if(name.toLowerCase().equals("q")) break;
			System.out.print("국어 점수를 입력해 주세요? :  ");
			String kor = in.readLine();
			System.out.print("영어 점수를 입력해 주세요? :  ");
			String eng = in.readLine();
			System.out.print("수학 점수를 입력해 주세요? :  ");
			String mat = in.readLine();
			
			int total = Integer.parseInt(kor) + Integer.parseInt(eng) +Integer.parseInt(mat);
			double aver = total/3.;
			String tot = Integer.toString(total);
			String avg =  Double.toString(aver);
			
			HashMap<String, String> map = new HashMap<>();
			map.put("이름", name);
			map.put("국어", kor);
			map.put("영어", eng);
			map.put("수학", mat);
			map.put("합계", tot);
			map.put("평균", avg);
			
			arr.add(map);
			}
		
		for (int i = 0; i < arr.size(); i++) {
		HashMap<String, String> map = arr.get(i);
		System.out.print(map.get("이름") + "/");
		System.out.print(map.get("국어") + "/");
		System.out.print(map.get("영어") + "/");
		System.out.print(map.get("수학") + "/");
		System.out.print(map.get("합계") + "/");
		System.out.println(map.get("평균") + "/");
		}
	
	
	
	
	}

}
