package time_afternoon;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("영국", "런던");
		map.put("미국", "워싱턴");
		map.put("호주", "켄버라");
		map.put("영국", "서울");
		System.out.println(map);
		
		System.out.println("-----------------------------");
		System.out.println(map.get("영국"));
		System.out.println(map.get("미국"));
		
		map.remove("영국");
		map.put("영국", "런던");
		System.out.println(map.size()); //크기를 구할 수 있다는 것은 반복문을 돌릴 수 있다는 의미이다.
		
		for(String s : map.keySet()) { //향상된 for 문. 
			System.out.println(s + " / " + map.get(s)); //키만 알면, 값을 구할 수있다. 그래서 요게 중요하다.
		}
		
		
		
		
	}

}
