package Time_Afternoon3;

import java.io.File;

public class GetFileInfo {

	public static void main(String[] args) {
		File myObj = new File ("D:\\2j\\attch\\test.txt");
		if(myObj.exists()) {
			System.out.println("�����̸� : " + myObj.getName());
			System.out.println("������ : " + myObj.getAbsolutePath());
			System.out.println("������ : " + myObj.length());
			}else {
				System.out.println("���Ͼ���");
			}
		
	}

}
