package Time_Afternoon3;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFIle {

	public static void main(String[] args) {
		try {
			FileWriter myWriter = new FileWriter("D:\\2j\\attch\\test.txt");
			myWriter.write("안녕하세요!!\n");
			myWriter.write("안녕하세요!!\n");
			myWriter.write("안녕하세요!!\n");
			myWriter.write("안녕하세요!!\n");
			myWriter.write("안녕하세요!!\n");
			myWriter.close();
		} catch (IOException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}

	}

}
