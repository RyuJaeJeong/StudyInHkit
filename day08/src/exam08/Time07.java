package exam08;

public class Time07 {
	int x = 10;
	int y = 20;
	public static void main(String[] args) {
		//Ŭ������ ������ ��ü�� �����ϰ� �������.
		//�ڷ��� ���� = new ������ ();
		//�����ڴ� Ŭ���� �̸��� ������ �޼ҵ��̴�.
	
		Time07 time07 = new Time07();
		System.out.println(time07.x);
		System.out.println(time07.y);
		
		time07.x = 10000;
		System.out.println(time07.x);
		
		Time07 time08 = new Time07();
		System.out.println(time08.x);
		System.out.println(time08.y);
	
	}
	
}
