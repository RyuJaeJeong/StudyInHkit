package test07;

import java.util.ArrayList;

public class ListTest01 {

	public static void main(String[] args) {
		//리스트 - ArrayList
		ArrayList cars = new ArrayList();
		cars.add("아반떼");
		System.out.println(cars); 
		
		cars.add("그랜저");
		System.out.println(cars);
		
		cars.add("제네시스");
		System.out.println(cars);
		
		cars.add(1, "소나타");
		System.out.println(cars); //인덱스값쓰면 지정된 인덱스에 들어가더라.
		
		cars.add("프라이드");
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
		//수정하더라, 인덱스값과 값 자체로도 지울수있는데 값 자체로 지우면 맨앞에꺼 하나만 
		cars.set(1, "볼보");
		System.out.println(cars);
		
		
		
		boolean r = cars.contains("그랜저");
		System.out.println(r);
		cars.add(100);
		System.out.println(cars);
		
		System.out.println(cars.indexOf("프라이드"));
		
	
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	arrayList.add(10);
	System.out.println(arrayList);
	
	//arrayList.add("A"); 오류 뜬다. 정수형이라 정의 내렸으니까.
	
	// array : 크기 고정, 자료형 고정
	// list : zmrlwpgksdjqtdma, wkfygud wpgks djqtdma
	
	/*
	 * list.add("값")
	 * list.add(인덱스, "값") ㅡ list.IndexOf("문자열")
	 * list.get(인덱스)
	 * list.set(인덱스, "값")
	 * list.size()
	 * 
	 */
	
	
	
	}

}

