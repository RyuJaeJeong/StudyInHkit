package Time_Afternoon3;

import java.io.File;
import java.io.IOException;

public class ReadFile {
	
	public static void main(String[] args) {
		File myObj = new File ("D:\\2j\\attch\\test.txt");
	
		try {
			if	(myObj.createNewFile()) {
				System.out.println("file created : " + myObj.getName());
			}	else {
				System.out.println("file already exists");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //try - catch ����ó�� 
		
		
		
		//����: ���α׷� �����߿� �߻��ϴ� ���� < - �����ڰ� �ذ� �ؾ���. 
		//����: �ϵ����, os(�ü��) <- ������ �ذ�(x)	
		
		
	}
	
}
/*
 * 
 * 
 * 
 * try( 
 * ���๮
 * ���๮
 * ���๮
 * 
 * ���๮
 * ���๮
 * ) catch(exception e) (
 * e.printStackTrace();
 * )finally (
 * "�������̵� ���ܰ� �߻��ߵ� ������ �����ϴ� �κ�."
 * )
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */