package exam03;

public class TestSwitch {

	public static void main(String[] args) {
		switch (5-1) {          //정수, 자바 1.7부터는 문자
		case 1 :                // 값
			System.out.println("1"); //실행문
			break;					 //브레이크가 온다. 	
		case 2 :	
			System.out.println("2");
			break;
		case 3 : 
			System.out.println("3");
			break;
		default :
			System.out.println("4");
		    
		}
	}
	
	
	
	
	
	
	
}
