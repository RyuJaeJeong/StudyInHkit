package day12;

public class time01EX {

	public static void main(String[] args) {
		
		time01 t1 = new time01();
		//�⺻�����ڸ� �̿��ؼ� ���ο� ��ü�� �����ϰ�
		//������ ��ü�� ���� ������ t1 �̶�� ��ü����(�ν��Ͻ�����)�� ��ƶ�.
		t1.setName("������");
		t1.setHeight(186);
		t1.setWeight(80);
		
		time01 t2 = new time01("������",168,64);
		time01 t3 = new time01("������");
		t3.setHeight(175);
		t3.setWeight(66);
		
		time01 t4 = new time01(180,80);
		t4.setName("����ȣ");
		t1.disp();
		t2.disp();
		t3.disp();
		t4.disp();
		
		
	}
	
}
