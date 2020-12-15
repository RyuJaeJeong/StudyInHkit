package exam103;

class Aaa {
	private int a = 8;
	
	public int getA( ) {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	
}







public class GetterSetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aaa gs1 = new Aaa();
		System.out.println(gs1.getA());
		gs1.setA(10000);
		System.out.println(gs1.getA());
	}

}
