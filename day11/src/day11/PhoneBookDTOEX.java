package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PhoneBookDTOEX {

	public static void main(String[] args) throws IOException {
		
		PhoneBookDTO2 [] arr = new PhoneBookDTO2[5];  
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new PhoneBookDTO2();
		}	
		
		
		
		for (int j = 0; j < arr.length; j++) {
			System.out.printf("\"%s, %s\"\n", arr[j].getName(), arr[j].getNum());
			}
		
		
		
		System.out.println("---------------------");
		

	}

}
