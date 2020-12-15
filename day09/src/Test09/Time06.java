package Test09;

public class Time06 {
//Fiedl
//생성자
	public Time06() {
		// TODO Auto-generated constructor stub
	}
//메서드
	int method1(int i) {
		int result = i + 5;
		return result;
	}
	
	int method(int i, int j) {
		int result = i + j;
		return result;
	}
	
	public static void main(String[] args) {
		Time06 t6 = new Time06();
		int result = t6.method1(5);
		System.out.println(result);
		int result2 = t6.method(5, 6);
		System.out.println(result2);
	}

}
