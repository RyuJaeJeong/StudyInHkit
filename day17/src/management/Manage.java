package management;

import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
//field
private String itemName;
private int itemPrice;
//������
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
		System.out.println("����(1:��ǰ��� 2:��ǰ��� 3:����)");
		int imsi = sc.nextInt();
		if (imsi==1) {
			System.out.println("��ǰ��-------��ǰ����\n");
			for (int i = 0; i < arr.size(); i++) {
				Manage prod = arr.get(i);
				System.out.println(prod.itemName+"-------"+prod.itemPrice);
			}
		}else if(imsi==2) {
			sc.nextLine();
			System.out.println("��ǰ�̸��� �Է��� �ּ���");
			String name = sc.nextLine();
			System.out.println("��ǰ������ �Է��� �ּ���");
			int price = sc.nextInt();
			arr.add(new Manage(name, price));
		}else if(imsi==3) {
			break;
		}
		
	}
	System.out.println("��ǰ���� ����");
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
