package exam03;



public class Test01 {
	public static void main(String[] args) {
		
	
	
	
	System.out.println(2020 - 1995 +1);
	
	int nowYear = 2020;
	int bornYear = 1995;
	
	int age = nowYear - bornYear + 1;
	
	String msg = "";
	msg = msg + "����� ���̴� "; //msg += "����� ���̴� "
	msg = msg + age;         //msg += age  
	msg = msg + "�� �Դϴ�.";  // msg += "�� �Դϴ�."
	
	System.out.println(msg);
	
	System.out.printf("����� ���̴� %d�� �Դϴ�.\n", age);
	
	String name = "������";
	int age1 = 26;
	
	System.out.println("\n����� �̸��� " + name + "�Դϴ�.\n" + "����� ���̴� " + age + "�� �Դϴ�.\n");
	System.out.printf("����� �̸��� %s�Դϴ�.\n����� ���̴� %d���Դϴ�.",name,age);
	
	
	
	
	
	
	
	
	
	
	}
	
}
