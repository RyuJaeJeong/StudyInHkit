package exam08;

public class Time07New {
	//<���>�ʵ�� �ʱ�ȭ�� �ȵǾ�������, �����Ϸ��� ������ �ϸ鼭 �ڵ����� �ʱ�ȭ ��Ų��.
	//String > null, int > 0 doeble> 0.0
	String fname;
	String lname;
	int age;
	
	public static void main(String[] args) {
		Time07New t1 = new Time07New();
		System.out.println(t1.lname);
		System.out.println(t1.fname);
		System.out.println(t1.age);
		
		t1.fname = "ȫ";
		t1.lname = "�浿";
		t1.age = 19;
		
		Time07New t2 = new Time07New();
		
		t2.fname = "��";
		t2.lname = "����";
		t2.age = 21;
		
		System.out.print(t2.fname);
		System.out.println(t2.lname);
		System.out.println(t2.age);
	}

}
