package time_morning2;

public class Example {

	public static void main(String[] args) {
		Exam2 e = new Exam2(); //����� �ϸ� ������ �Ⱥ������� �θ�ü - �ڽİ�ü ��� ���������. 
							   //�θ������ ���� ����ǰ� ���߿� �ڽ� ������ ����ȴ�.
		System.out.println(e.color1);
		System.out.println(e.color2);
		System.out.println(e.color3);
		System.out.println();
		System.out.println(e.getFlower1());
		System.out.println(e.getFlower2());
		System.out.println(e.getFlower3());
	
		e.test();
		
		//�޼ҵ� ������ - �޼ҵ� overriding
		
	}

}
