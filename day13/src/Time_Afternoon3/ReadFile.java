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
		}   //try - catch 예외처리 
		
		
		
		//예외: 프로그램 실행중에 발생하는 문제 < - 개발자가 해결 해야함. 
		//에러: 하드웨어, os(운영체제) <- 개발자 해결(x)	
		
		
	}
	
}
/*
 * 
 * 
 * 
 * try( 
 * 실행문
 * 실행문
 * 실행문
 * 
 * 실행문
 * 실행문
 * ) catch(exception e) (
 * e.printStackTrace();
 * )finally (
 * "정상적이든 예외가 발생했든 무조건 실행하는 부분."
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