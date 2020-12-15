package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneBookDTO2 {

	//field
	private String name;
	private String num;
	
	//constructor
	
	public PhoneBookDTO2() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("이름 : ");
		String name = in.readLine(); 
		System.out.println("번호 : ");
		String num = in.readLine();
			
	}

	
	//method
	
	
	
	//getter.setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
		
	}
	
	
	


