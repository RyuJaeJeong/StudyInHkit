package Time04;

public  class Animal { //클래스 앞에 파이널 붙이면상속 못한다는 이야기. 메서드 앞에 붙으면 오버라이딩 못한다.
	public void method1 () {
		System.out.println("-- method1()--");
	}
	
	public void method2 () {
		System.out.println("--method2()--");
	}
	
	public final void  method3() {
		System.out.println("--method3()--");
	}
}
