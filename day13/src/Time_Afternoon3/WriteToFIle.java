package Time_Afternoon3;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFIle {

	public static void main(String[] args) {
		try {
			FileWriter myWriter = new FileWriter("D:\\2j\\attch\\test.txt");
			myWriter.write("�ȳ��ϼ���!!\n");
			myWriter.write("�ȳ��ϼ���!!\n");
			myWriter.write("�ȳ��ϼ���!!\n");
			myWriter.write("�ȳ��ϼ���!!\n");
			myWriter.write("�ȳ��ϼ���!!\n");
			myWriter.close();
		} catch (IOException e) {
			System.out.println("���ܹ߻�");
			e.printStackTrace();
		}

	}

}
