package Time04;

public class Dog extends Animal {

	public void method1 () {
		System.out.println("-- child method1()--");
	}
	
	public void method2 () {
		System.out.println("--child method2()--");
	}
	
	//method3에는 final이 붙어서 오버라이딩 할 수 없다.
	
}
