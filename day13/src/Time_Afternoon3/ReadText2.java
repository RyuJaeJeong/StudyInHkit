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
			msg += "�̸�\t";
			msg += "����\t";
			msg += "����\t";
			msg += "����\t";
			msg += "����\t";
			msg += "����\t";
			msg += "�հ�\t";
			msg += "���\n";
			while(sc.hasNextLine()) {
				String data = sc.nextLine();
				HashMap<String, String> map = new HashMap<>();
				arr = data.split(",");
				map.put("�̸�", arr[0]);	
				map.put("����", arr[1]);
				map.put("����", arr[2]);
				map.put("����", arr[3]);
				map.put("����", arr[4]);
				map.put("����", arr[5]);
				int kor = Integer.parseInt(arr[1]);
				int eng = Integer.parseInt(arr[2]);
				int mat = Integer.parseInt(arr[3]);
				int sci = Integer.parseInt(arr[4]);
				int his = Integer.parseInt(arr[5]);
				int tot = kor + eng + mat + sci + his;
				double avg = tot/5.0;
				String total = Integer.toString(tot);
				String average = Double.toString(avg);
				map.put("�հ�", total);
				map.put("���", average);
				
				msg += map.get("�̸�") + "\t";
				msg += map.get("����") + "\t";
				msg += map.get("����") + "\t";
				msg += map.get("����") + "\t";
				msg += map.get("����") + "\t";
				msg += map.get("����") + "\t";
				msg += map.get("�հ�") + "\t";
				msg += map.get("���") + "\t\n";
					
			
			}
			
				
				
		} catch (FileNotFoundException e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}
		

	}

}
