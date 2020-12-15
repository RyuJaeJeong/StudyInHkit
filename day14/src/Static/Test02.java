package Static;

public class Test02 {

	public static void main(String[] args) {
//		Test01 t1 = new Test01(5);
//		System.out.println(t1.a);
//		t1.disp();
		Test01.a = 9;
		Test01.disp(); 	//객체 일률 적으로 적용 시킬 값이 있으면 모두  static	
	}

}
