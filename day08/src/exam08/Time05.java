package exam08;

public class Time05 {
	static void prn(String[] n) { //parameter
		n[2] = "박철순";
		System.out.println(n[2]);
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i] + " 이곳은 prn");
		}
	}
	
	
	
	public static void main(String[] args) {
		String[] names = {"홍길동", "이성순", "장천용", "이상대"};
		prn(names); //prn이라는 메서드에 names라는 문자열 배열을 집어넣어 실행해라. 아규먼트 
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "여기는 메인메서드");
		}
	}

}
