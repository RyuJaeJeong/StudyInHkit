package Test09;

public class Time05 {
//�ʵ�, ������, �޼ҵ�
	//�ʵ�
	String str;
	int num;
	//������
	public Time05() {}
	//�޼ҵ�. ���밡�ɼ����ִ� ���� �̸� ��� �س���, �ʿ��Ҷ����� ȣ��.	
	void method1 () {
		System.out.println("--method1--");
	}
	
	void method1 (String name) {
		System.out.println(name + "��, �ȳ��ϼ���?");
	}
	void method1 (String name,int age ) {
		System.out.println("�̸�:" + name+"\n"+ "���� : " + age);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static>������ ����. ��ü ���� �����ʰ� ������ �� 
	Time05 t5 = new Time05();	
		t5.method1();
		t5.method1();
		t5.method1();
		
		t5.method1("ȫ�浿");
		t5.method1("ȫ�̵�");
		t5.method1("ȫ�ﵿ");
		
		t5.method1("������", 26);
	}
	

}
