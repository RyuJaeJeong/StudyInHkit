
public class Record2 extends Record {
//field
private int tot;
private int avg;


//cons
public Record2() {
	// TODO Auto-generated constructor stub
}


public Record2(String name, int lang, int eng, int mat) {
	setName(name);
	setLang(lang);
	setEng(eng);
	setMat(mat);
	tot = getLang() + getEng() + getMat();
	avg = tot/3;
}


//method

public void disp() {
	System.out.println(getName() +"/"+ getLang() +"/"+ getEng() +"/"+ getMat()+"/"+tot+"/"+avg); 
}


//getter&setter
public int getTot() {
	return tot;
}
public void setTot(int tot) {
	this.tot = tot;
}
public int getAvg() {
	return avg;
}
public void setAvg(int avg) {
	this.avg = avg;
}





}
