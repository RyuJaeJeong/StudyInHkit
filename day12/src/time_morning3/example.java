package time_morning3;

public class example {
//��ü���� ���α׷��� 4�� Ư��
	/*
	 * ĸ��ȭ : Getter&Setter
	 * ��� : �θ��� ����� ���� �޴°�. ������ 
	 * �߻�ȭ : �� ��ﲨ
	 * ������ : 
	 * */
	public static void main(String[] args) {
		dog d1 = new dog("�ٵ���",3); //�θ� �����ڰ� ���� ����Ǳ⶧���� �־�����Ѵ�. 
		System.out.println(d1.age);
		System.out.println(d1.name);
		d1.sound(); //
		d1.display();
		cat c1 = new cat("�ֺ�",5);
		c1.sound();
		
		c1.display();
		
		bird b1 = new bird("����",2);
		b1.sound();
		b1.display();
	}

}
