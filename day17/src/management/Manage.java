package management;

import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
//field
private String itemName;
private int itemPrice;
//생성자
public Manage() {
	
}



public Manage(String itemName, int itemPrice) {
	this.itemName = itemName;
	this.itemPrice = itemPrice;
}





//method
public void goodManage () {
	Scanner sc = new Scanner(System.in);
	ArrayList<Manage> arr = new ArrayList(); 
	while(true) {
		System.out.println("선택(1:상품목록 2:상품등록 3:종료)");
		int imsi = sc.nextInt();
		if (imsi==1) {
			System.out.println("상품명-------상품가격\n");
			for (int i = 0; i < arr.size(); i++) {
				Manage prod = arr.get(i);
				System.out.println(prod.itemName+"-------"+prod.itemPrice);
			}
		}else if(imsi==2) {
			sc.nextLine();
			System.out.println("상품이름을 입력해 주세요");
			String name = sc.nextLine();
			System.out.println("상품가격을 입력해 주세요");
			int price = sc.nextInt();
			arr.add(new Manage(name, price));
		}else if(imsi==3) {
			break;
		}
		
	}
	System.out.println("상품관리 종료");
}


//getter&setter
public String getItemName() {
	return itemName;
}



public void setItemName(String itemName) {
	this.itemName = itemName;
}



public int getItemPrice() {
	return itemPrice;
}



public void setItemPrice(int itemPrice) {
	this.itemPrice = itemPrice;
}

}
