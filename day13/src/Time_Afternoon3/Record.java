package Time_Afternoon3;

public class Record {
//Field 
String name; 
int kor;
int eng;
int mat;
int sci;
int his;
int tot;
int avg;

//cons
public Record() {
	
}

public Record(String name, int kor, int eng, int mat, int sci, int his) {
	
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.mat = mat;
	this.sci = sci;
	this.his = his;
	this.tot = kor + eng + mat + sci + his;
	this.avg = tot/5;
	
}



//method

public void dis() {
	System.out.println(name + "/" + kor + "/" + eng + "/" + mat +"/" + sci +  "/" + his +  "/" +tot +  "/" + avg );
}

}
