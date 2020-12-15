package ex04;

public class Student {
//field
private String name;
private int kor;
private int eng;
private int mat;
private int tot;
private double aver;

	
//constructor
public Student() {
	// TODO Auto-generated constructor stub
}



public Student(String name, int kor, int eng, int mat) {
	
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.mat = mat;
	cal(); //합계와 평균 구하는 메서드를 호출
}



//method
public void cal () {
	tot = kor + eng + mat;
	aver = tot/3.0;
}

public void display () {
	System.out.println(name +"\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + aver);
}





//getter & setter
public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getKor() {
	return kor;
}


public void setKor(int kor) {
	this.kor = kor;
}


public int getEng() {
	return eng;
}


public void setEng(int eng) {
	this.eng = eng;
}


public int getMat() {
	return mat;
}


public void setMat(int mat) {
	this.mat = mat;
}


public int getTot() {
	return tot;
}


public void setTot(int tot) {
	this.tot = tot;
}


public double getAver() {
	return aver;
}


public void setAver(double aver) {
	this.aver = aver;
}







}
