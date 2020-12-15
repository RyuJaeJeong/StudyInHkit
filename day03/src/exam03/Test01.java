package exam03;



public class Test01 {
	public static void main(String[] args) {
		
	
	
	
	System.out.println(2020 - 1995 +1);
	
	int nowYear = 2020;
	int bornYear = 1995;
	
	int age = nowYear - bornYear + 1;
	
	String msg = "";
	msg = msg + "당신의 나이는 "; //msg += "당신의 나이는 "
	msg = msg + age;         //msg += age  
	msg = msg + "세 입니다.";  // msg += "세 입니다."
	
	System.out.println(msg);
	
	System.out.printf("당신의 나이는 %d세 입니다.\n", age);
	
	String name = "류재정";
	int age1 = 26;
	
	System.out.println("\n당신의 이름은 " + name + "입니다.\n" + "당신의 나이는 " + age + "세 입니다.\n");
	System.out.printf("당신의 이름은 %s입니다.\n당신의 나이는 %d세입니다.",name,age);
	
	
	
	
	
	
	
	
	
	
	}
	
}
