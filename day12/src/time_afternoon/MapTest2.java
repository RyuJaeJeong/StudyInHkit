package time_afternoon;

import java.util.HashMap;

public class MapTest2 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("ȫ�浿", 19);
		map.put("�̼���", 21);
		map.put("��õ��", 27);
		map.put("�輮��", 22);
		map.put("�̼���", 17);
		
		map.put("�̼���", 51); //�߰��� �ƴ� ������. 
		
		System.out.println(map); //���� �ε��� ������ �ƴϱ⶧���� ������ �ٸ� ���ִ�. 
		for(String s : map.keySet()) {
			System.out.println("key: "+s+"/"+map.get(s));
		}
	}

}
