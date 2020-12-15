package examafternoon3;








//static °øÀ¯ÀÇ °³³äÀÌ ÀÖ´Ù. 

class Tmp{
	String name;
	int money;
	static double iyul;
	double total;


public Tmp(String name, int money) {
	this.name = name;
	this.money = money;
	this.total = money + (money*this.iyul);
	
	System.out.println(name + "\t" + total);
	
}









}






public class test000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tmp.iyul = 0.01;
		Tmp t1 = new Tmp("È«±æµ¿", 10000); 
		Tmp t2 = new Tmp("È«±æµ¿", 50000); 
		Tmp t3 = new Tmp("È«±æµ¿", 30000); 
		
		
		
	}

}
