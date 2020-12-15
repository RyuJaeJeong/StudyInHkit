package exam03;

public class Test06 {

	public static void main(String[] args) {
		int a = 5;
		if (a%2 == 0) {
			System.out.println("짝수입니다");
		}else {
			System.out.println("홀수입니다.");
		}
		
//같다는 표시는 등호 2개, =는 집어넣어라는뜻. 
		System.out.println("==프로그램 종료==");
		
		
		int b = 3;
				if(a+b==0) {
					System.out.println("1");
				}else {
					System.out.println("2");
				}
		
				String c = "5";
				if (c.equals("5")) {        //중요함. 
					System.out.println("3");
				} else { 
					System.out.println("4");
				}  //문자로 처리하면 비교연산자를 못쓴다. 
				
				boolean bo = a>b;
				
				if (bo == true) {
					System.out.println("5");
				} else { 
					System.out.println("6");
				
				}
		
				
				
				if (a>3 && a>9) {
					System.out.println("T");
				} else {
					System.out.println("F");
				}	
				
		
		/*
		 * if (조건)
   실행문 





if (조건)(
  실행문
)





*다중 if문 <--> switch 

if (조건) (
   실행문
)  else(
   실행문
)


if (조건)  (
 실행문
) else if (조건) (
 실행문
) else if (조건) (
 실행문
) else (
)
		 * */
		
		
		
		

	}

}
