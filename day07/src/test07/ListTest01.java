package test07;

import java.util.ArrayList;

public class ListTest01 {

	public static void main(String[] args) {
		//����Ʈ - ArrayList
		ArrayList cars = new ArrayList();
		cars.add("�ƹݶ�");
		System.out.println(cars); 
		
		cars.add("�׷���");
		System.out.println(cars);
		
		cars.add("���׽ý�");
		System.out.println(cars);
		
		cars.add(1, "�ҳ�Ÿ");
		System.out.println(cars); //�ε��������� ������ �ε����� ������.
		
		cars.add("�����̵�");
		System.out.println(cars);
		
		System.out.println(cars.get(0));
		System.out.println(cars.get(1));
		System.out.println(cars.get(2));
		System.out.println(cars.get(3));
		System.out.println(cars.get(4));
		
		System.out.println(cars.size());
		
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i));
		}
		
		//set remove....
		//�����ϴ���, �ε������� �� ��ü�ε� ������ִµ� �� ��ü�� ����� �Ǿտ��� �ϳ��� 
		cars.set(1, "����");
		System.out.println(cars);
		
		
		
		boolean r = cars.contains("�׷���");
		System.out.println(r);
		cars.add(100);
		System.out.println(cars);
		
		System.out.println(cars.indexOf("�����̵�"));
		
	
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	arrayList.add(10);
	System.out.println(arrayList);
	
	//arrayList.add("A"); ���� ���. �������̶� ���� �������ϱ�.
	
	// array : ũ�� ����, �ڷ��� ����
	// list : zmrlwpgksdjqtdma, wkfygud wpgks djqtdma
	
	/*
	 * list.add("��")
	 * list.add(�ε���, "��") �� list.IndexOf("���ڿ�")
	 * list.get(�ε���)
	 * list.set(�ε���, "��")
	 * list.size()
	 * 
	 */
	
	
	
	}

}

