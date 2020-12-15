package exam102;


class Imsi {
	//field
	int s = 100;
	
	//constructor 
	//method
	void aaa ( ) {
		int s = 10; //지역변수
		s = s + 5;
		System.out.println(s);
	}
	void bbb( ) {
		
		s = s + 5;
		System.out.println(s);
	}
	void ccc ( ) {
	
		s = s + 5;
		System.out.println(s);
	}
}









public class Aaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Imsi i1 = new Imsi();
		i1.aaa();
		i1.bbb();
		i1.ccc();
	}

}
