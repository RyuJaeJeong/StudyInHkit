package exam01;

public class ���ڿ�����{

	public static void main(String[] args) {
		
		String name = "ȫ�浿";
		int age = 19; 
		
//		System.out.println("�Է��Ͻ� �̸��� "+name+ "�̸�, ���̴� " + age + "���Դϴ�.");
//		//���ڿ� ������ �̿��ϸ� �˴ϴ�. 
//		
//		String message = "";
//		message = message + "�Է��Ͻ� �̸��� ";
//		message = message + name;
//		message = message + "�̸�, ���̴� ";
//		message = message + age;
//		message = message + "�� �Դϴ�.";
//			System.out.println(message);
//���ڿ� : ���ڿ� + ���ڿ� + ���ڿ� + ���� + ���ڿ� (���ڰ� ���ڷ� �ٲ�� ������ ���ڰ� �����Ǽ� ���´�.
//���ڿ� ���꿡���� �������, ���� Ȯ�� �߿��ϴ�..!!!!
			
			System.out.printf("����� �̸��� %s�Դϴ�.", name);
			System.out.printf("����� ���̴� %d�Դϴ�.", age);
			System.out.printf("����� ���̴� %s�Դϴ�.", age);
			
			//print f : %d(����) %f(�Ǽ�) %c(����) %s(���ڿ�)
			
	String message = "";
	message = message + "\n����� �̸��� ";
	message = message + name;
	message = message + " �Դϴ�.";
	message = message + "����� ���̴�";
    message = message + age;
	message = message + "�� �Դϴ�.";
	
	System.out.println(message);
	
	
	
	char aaa = 'A';
	
	System.out.println("\n" + aaa );
	
	
	//unsigned : ����� ����. 
	
	}

}
