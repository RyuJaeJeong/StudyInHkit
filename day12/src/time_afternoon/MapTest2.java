package time_afternoon;

import java.util.HashMap;

public class MapTest2 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("홍길동", 19);
		map.put("이성순", 21);
		map.put("장천용", 27);
		map.put("김석원", 22);
		map.put("이석재", 17);
		
		map.put("이석재", 51); //추가가 아닌 수정임. 
		
		System.out.println(map); //맵은 인덱스 개념이 아니기때문에 순서는 다를 수있다. 
		for(String s : map.keySet()) {
			System.out.println("key: "+s+"/"+map.get(s));
		}
	}

}
