package exam15_2;

public class Example {

	public static void main(String[] args) {
		InterfacePR a;
		
		//(매게변수) -> (실행문);
		a = (x, y) -> {
			System.out.println(x + y +3);
		}; 
		a.method01(3,2); //이것이 람다. 실행클래스의 객체 없이 일회용 함수를 만들어쓰는것. 
	}

}
