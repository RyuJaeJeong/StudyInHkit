package list;

import java.util.ArrayList;

public class PhoneBookDTOEX {

	public static void main(String[] args) {
		
		ArrayList<PhoneBookDTO> pblist = new ArrayList<>();
		
		
		
		pblist.add(new PhoneBookDTO("È«±æµ¿","010-1111-1111",19));

		
		
		pblist.add(new PhoneBookDTO("ÀÌ»ó¼ø","010-2222-2222",25));
	
		
		pblist.add(new PhoneBookDTO("¸Ó½¬º£³ð", "010-9999-9999",32));
		System.out.print(pblist.size() + "/");
		System.out.println(pblist);
		
		for (int i = 0; i < pblist.size(); i++) {
			
			pblist.get(i).display();
			
		}
		
		
	}

}
