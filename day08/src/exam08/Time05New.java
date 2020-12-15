package exam08;

public class Time05New {
	static void prn(String...a) {
		for (int j = 0; j < a.length; j++) {
			System.out.println("a" + "[" + j + "]" + ":" + a[j]);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// 메소드 오버로딩(overLoading)
		// 메소드 오버라이딩(overriding) == 메소드 제정의
		
		
		prn("자바");
		prn("자바는", " 어렵다.");
		prn("자바는"," 매우 ","어렵다.");
		
	}

}
