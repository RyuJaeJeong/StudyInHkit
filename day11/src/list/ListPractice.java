package list;

import java.util.ArrayList;

public class ListPractice {

	public static void main(String[] args) {
		
		
		ArrayList<String> list = new ArrayList<String>(); //제너릭이라는걸 써서 리스트 안에 들어갈 자료형을 고정해준다. 
		System.out.println("리스트 길이 : " + list.size());
		list.add("그랜저");
		System.out.println("리스트 길이 : " + list.size());
		list.add("제네시스");
		System.out.println("리스트 길이 : " + list.size());
		list.add("소나타");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		list.set(0, "프라이드");
		System.out.println(list.get(0));
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(0);  //지우고나면, 한칸씩 당겨진다. 
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+" ");          
		}
		
		
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		
		//nums.add(1);
		//nums.add(1,2); //첫번째 인덱스에 2를 집어넣어라 
		
		for (int i = 0; i <=10; i++) {
			nums.add(i);
		}
		
		System.out.println(nums);
		
		for (int num : nums) {
			System.out.println(num);
		}
		
		
		
		
		
		
		
		
		
	}

}
