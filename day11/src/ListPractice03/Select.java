package ListPractice03;

import java.util.Scanner;

public class Select {
//Field
private String name;
private String num;
//Constructor
public Select() {
	Scanner sc = new Scanner(System.in);
	System.out.println("이름 : ");
	name = sc.nextLine();
	System.out.println("번호 : ");
	num = sc.nextLine();
	
}
//Method	
public void display() {
	
	System.out.println(name + "/" + num);
}



	






//getter&setter 
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
