package ListPractice;

import java.io.IOException;
import java.util.ArrayList;

public class PhoneBookUse {

	public static void main(String[] args) throws IOException {
		
		ArrayList<PhoneBook> nums = new ArrayList<>();
		
		for (int i = 0; i <5; i++) {
			nums.add(new PhoneBook());
		}
		
		for (int i = 0; i < nums.size(); i++) {
			nums.get(i).display();
		}
		
		for (int i = 0; i < nums.size(); i++) {
			System.out.println(nums);
		}
	}

}
