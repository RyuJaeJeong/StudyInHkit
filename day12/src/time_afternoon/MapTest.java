package time_afternoon;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("����", "����");
		map.put("�̱�", "������");
		map.put("ȣ��", "�˹���");
		map.put("����", "����");
		System.out.println(map);
		
		System.out.println("-----------------------------");
		System.out.println(map.get("����"));
		System.out.println(map.get("�̱�"));
		
		map.remove("����");
		map.put("����", "����");
		System.out.println(map.size()); //ũ�⸦ ���� �� �ִٴ� ���� �ݺ����� ���� �� �ִٴ� �ǹ��̴�.
		
		for(String s : map.keySet()) { //���� for ��. 
			System.out.println(s + " / " + map.get(s)); //Ű�� �˸�, ���� ���� ���ִ�. �׷��� ��� �߿��ϴ�.
		}
		
		
		
		
	}

}
