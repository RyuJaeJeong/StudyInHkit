package Time02;

public class PolymorphizmTest {
	public static void main(String[] args) {
		Animal ani = new Animal();
		ani.sound();
		
		Animal ani02 = new Dog();
		ani02.sound(); //�ڵ�����ȯ , �θ�Ÿ���� ������ �ڽ� ��ü�� ��������ϱ� �ڵ� ����ȯ�� �Ͼ����. ����Ҽ��ִ� �����  �θ� ���. 
		
		Animal ani03 = new Cat();
		ani03.sound();
		
		Animal ani04 = new Bird();
		ani04.sound();
		
	/*
	 *  ������ :  ����ȯ + �������̵� 
	 *  �θ�Ÿ���� ������ �ڽİ�ü�� ����ִ°� 
	 *  �θ�Ÿ�Կ� ���� �־��� ������ ����Ҽ� �ִ� ����� �θ��� �͸� ����
	 *  �׷��� �޼ҵ� �����ǰ� �Ǿ������� �θ���� �ƴ� �ڽİ� ����.
	 * 
	 *��ü���� ���α׷� 4�� Ư¡
	 *ĸ��ȭ(����ȭ)
	 *���
	 *������
	 *�߻�ȭ 
	 * */
		 
		
		System.out.println("--------------");
		ani = new Animal();
		ani.dispA();
		ani.sound();
		ani = new Dog();
		ani.dispA();
		ani.sound();
		ani = new Cat();
		ani.dispA();
		ani.sound();
		ani = new Bird();
		ani.dispA();
		ani.sound();
	}
}
