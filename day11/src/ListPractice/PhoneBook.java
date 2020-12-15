package ListPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneBook {
//Field 
private String name;
private String num;
private int age;	


//cons
public PhoneBook() throws IOException {
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
System.out.println("이름 : ");
name = in.readLine();
System.out.println("번호 : ");
num = in.readLine();
System.out.println("나이 : ");
age =Integer.parseInt(in.readLine());

}



//method
public void display() {
	System.out.println(name+"/"+num+"/"+age);
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



public int getAge() {
	return age;
}



public void setAge(int age) {
	this.age = age;
}





	
}
