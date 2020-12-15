package time_morning4;

import java.util.Scanner;

public class BookSale extends Book {
	//field
	private int amount;	//�Ǹż�
	private int rank;	//����
	private	int money;	//�Ǹűݾ�(�ܰ�*����, 10���� �ʰ��� 10%����)
	
	//cons
	

	public BookSale() {
		
	}
	
	
	
	
	public BookSale(String bookName, String author, String maker, int year, int price, int amount, int rank) {
		super(bookName,author,maker,year,price);
		this.amount = amount;
		this.rank = rank;
		moneyCal();
	}
	

	//method
	public void moneyCal () {
		int imsi = price*amount;
		
		if (imsi>=100000) {
			money = (int)(imsi*0.9); // 90/100 �ϸ� ���� 0�� ��µ� ������. 
			
		} else{
			money = imsi;
		}
		
		
	}
	

   public void disp() {
	   String msg = "";
	   msg += getBookName() + "\t";
	   msg += getAuthor() + "\t";
	   msg += getMaker() + "\t";
	   msg += getYear() + "\t";
	   msg += getPrice() + "\t";
	   
	   msg +=amount + "\t";
	   msg += rank + "\t";
	   msg += money + "\t";
	   System.out.println(msg);
   }

   //getter&setter
public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public int getRank() {
	return rank;
}

public void setRank(int rank) {
	this.rank = rank;
}

public int getMoney() {
	return money;
}

public void setMoney(int money) {
	this.money = money;
}

   
   
   





}

