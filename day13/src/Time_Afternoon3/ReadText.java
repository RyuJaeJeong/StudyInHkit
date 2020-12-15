package Time_Afternoon3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = new String[6];
		System.out.println(arr);
		
		String msg ="";
		try {
			File myObj = new File ("D:\\2j\\attch\\test.txt"); 
			int i = 0;
			Scanner sc = new Scanner(myObj);
			while(sc.hasNextLine()) {
				String data = sc.nextLine();
				arr = data.split(",");
				
				System.out.println(arr[0]);}
				Record r = new Record(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]),Integer.parseInt(arr[5]));
				System.out.println(arr);
				
				
			
				
			
		} catch (FileNotFoundException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}
		
	}

}
