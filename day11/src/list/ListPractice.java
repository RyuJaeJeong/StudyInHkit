package list;

import java.util.ArrayList;

public class ListPractice {

	public static void main(String[] args) {
		
		
		ArrayList<String> list = new ArrayList<String>(); //���ʸ��̶�°� �Ἥ ����Ʈ �ȿ� �� �ڷ����� �������ش�. 
		System.out.println("����Ʈ ���� : " + list.size());
		list.add("�׷���");
		System.out.println("����Ʈ ���� : " + list.size());
		list.add("���׽ý�");
		System.out.println("����Ʈ ���� : " + list.size());
		list.add("�ҳ�Ÿ");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		list.set(0, "�����̵�");
		System.out.println(list.get(0));
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(0);  //�������, ��ĭ�� �������. 
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+" ");          
		}
		
		
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		
		//nums.add(1);
		//nums.add(1,2); //ù��° �ε����� 2�� ����־�� 
		
		for (int i = 0; i <=10; i++) {
			nums.add(i);
		}
		
		System.out.println(nums);
		
		for (int num : nums) {
			System.out.println(num);
		}
		
		
		
		
		
		
		
		
		
	}

}
