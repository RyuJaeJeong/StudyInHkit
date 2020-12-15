package exam06;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input ="";
		
//		while(true) {
//			System.out.print("선택하세요(0:종료 1:목록 2:등록) : ");
//			input = sc.nextLine();
//			if(input.equals("0")) {
//				break;
//			} else if (input.equals("1")) {
//				System.out.println("--목록--");
//			} else if (input.equals("2")) {
//				System.out.println("--등록--");
//			} else {
//				continue;
//			}
//		}
		
//	  do  { 
//		  System.out.print("선택하세요(0:종료 1:목록 2:등록) : ");
//			input = sc.nextLine();
//			if(input.equals("0")) {
//				break;
//			} else if (input.equals("1")) {
//				System.out.println("--목록--");
//			} else if (input.equals("2")) {
//				System.out.println("--등록--");
//			} else {
//				continue;  
//		  
//	  }
//			
//	  }		while(true);
//	
		  System.out.println("----------------");
		  System.out.println("0:종료 1:목록 2:등록");
		  System.out.println("----------------");
		
	  for(;;) {
		  
		  System.out.print("선택하세요 : ");
			input = sc.nextLine();
			if(input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				System.out.println("--목록--");
			} else if (input.equals("2")) {
				System.out.println("--등록--");
			} else {
				continue;  
		  
			}		
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	
	
	
	}

}
