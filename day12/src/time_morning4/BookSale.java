package time_morning4;

import java.util.Scanner;

public class BookSale extends Book {
	//field
	private int amount;	//판매수
	private int rank;	//순위
	private	int money;	//판매금액(단가*수량, 10만원 초과시 10%할인)
	
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
			money = (int)(imsi*0.9); // 90/100 하면 몫인 0만 출력되 버린다. 
			
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

