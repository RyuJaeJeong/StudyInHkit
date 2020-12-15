package examafternoon3;

import java.text.DecimalFormat;

public class BookDTO {
//field
private String bookName;
private String author;
private String maker;
private String year;
private int price;
private int number;
private int money;
//constructor
	public BookDTO(String bookName, String author, String maker, String year, int price, int number)
	{ this.bookName = bookName;
	  this.author = author;
	  this.maker = maker;
	  this.year = year;
	  this.price = price;
	  this.number = number;
	  money = price*number;
	display();
}	
//method	
public void display ( ) {
	DecimalFormat fm = new DecimalFormat("###,###");
	String msg = "";
	msg += bookName;
	msg +="\t";
	msg += author;
	msg +="\t";
	msg += maker;
	msg += "\t";
	msg += year;
	msg += "\t";	
	msg += price;
	msg += "\t";
	msg += number;
	msg += "\t";	
	msg += fm.format(money);
	msg += "\t";	
	System.out.println(msg);
	}










}
