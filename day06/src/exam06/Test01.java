package exam06;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input ="";
		
//		while(true) {
//			System.out.print("�����ϼ���(0:���� 1:��� 2:���) : ");
//			input = sc.nextLine();
//			if(input.equals("0")) {
//				break;
//			} else if (input.equals("1")) {
//				System.out.println("--���--");
//			} else if (input.equals("2")) {
//				System.out.println("--���--");
//			} else {
//				continue;
//			}
//		}
		
//	  do  { 
//		  System.out.print("�����ϼ���(0:���� 1:��� 2:���) : ");
//			input = sc.nextLine();
//			if(input.equals("0")) {
//				break;
//			} else if (input.equals("1")) {
//				System.out.println("--���--");
//			} else if (input.equals("2")) {
//				System.out.println("--���--");
//			} else {
//				continue;  
//		  
//	  }
//			
//	  }		while(true);
//	
		  System.out.println("----------------");
		  System.out.println("0:���� 1:��� 2:���");
		  System.out.println("----------------");
		
	  for(;;) {
		  
		  System.out.print("�����ϼ��� : ");
			input = sc.nextLine();
			if(input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				System.out.println("--���--");
			} else if (input.equals("2")) {
				System.out.println("--���--");
			} else {
				continue;  
		  
			}		
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	
	
	
	}

}
