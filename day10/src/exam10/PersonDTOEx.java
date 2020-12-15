package exam10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonDTOEx {

	public static void main(String[] args) throws IOException {
		//1. 객체를 생성한다. 
		//2. 저장할 값을 입력받아야한다. 혹은 객체생성중에 입력을 먼저 받아야할 수도있다.
		//2.5 찍어본다. 
		//3. 객체에 집어넣는다.
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("이름 : ");
		String name = in.readLine();
		
		System.out.println("나이 : ");
		int age = Integer.parseInt(in.readLine());
		
		System.out.println("키 : ");
		double height = Double.parseDouble(in.readLine());
		
		System.out.println("몸무게 : ");
		double weight = Double.parseDouble(in.readLine());
		
		
		//xml, json 어떻게 하면 데이터를 조금 더 쉽게 받을까?
		
		
		//PersonDTO p1 = new PersonDTO();
		//기본 생성자를 이용하겠다는 이야기.
		
		PersonDTO p2 = new PersonDTO(name, age, height, weight);
		//매개변수를 이용해서 객체를 생성한다. 
		
		
		
		
	}

}
