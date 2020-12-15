package Time_Afternoon3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ReadText2 {

	public static void main(String[] args) {
		String[] arr = new String[6];
		System.out.println(arr);
		
		String msg ="";
		try {
			File myObj = new File ("D:\\2j\\attch\\test.txt"); 
			int i = 0;
			Scanner sc = new Scanner(myObj);
			msg += "이름\t";
			msg += "국어\t";
			msg += "영어\t";
			msg += "수학\t";
			msg += "역사\t";
			msg += "과학\t";
			msg += "합계\t";
			msg += "평균\n";
			while(sc.hasNextLine()) {
				String data = sc.nextLine();
				HashMap<String, String> map = new HashMap<>();
				arr = data.split(",");
				map.put("이름", arr[0]);	
				map.put("국어", arr[1]);
				map.put("영어", arr[2]);
				map.put("수학", arr[3]);
				map.put("역사", arr[4]);
				map.put("과학", arr[5]);
				int kor = Integer.parseInt(arr[1]);
				int eng = Integer.parseInt(arr[2]);
				int mat = Integer.parseInt(arr[3]);
				int sci = Integer.parseInt(arr[4]);
				int his = Integer.parseInt(arr[5]);
				int tot = kor + eng + mat + sci + his;
				double avg = tot/5.0;
				String total = Integer.toString(tot);
				String average = Double.toString(avg);
				map.put("합계", total);
				map.put("평균", average);
				
				msg += map.get("이름") + "\t";
				msg += map.get("국어") + "\t";
				msg += map.get("영어") + "\t";
				msg += map.get("수학") + "\t";
				msg += map.get("역사") + "\t";
				msg += map.get("과학") + "\t";
				msg += map.get("합계") + "\t";
				msg += map.get("평균") + "\t\n";
					
			
			}
			
				
				
		} catch (FileNotFoundException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}
		

	}

}
