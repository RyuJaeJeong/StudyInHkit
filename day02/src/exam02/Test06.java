package exam02;

public class Test06 {

	public static void main(String[] args) {
		
		int kor = 83;
		int eng = 93;
		int mat = 81;
		
		int plus = kor + eng + mat;
		double pyeon = plus/(double)3;  //정수와 정수의 연산결과는 무조건 정수만 나온다 컴퓨터에서는. 그래서 한쪽만 이라도 실수로 바꿔준다
		
		/* double pyeong = plus/3.0;
		 * double pyeong = (double)plus/3.0;
		 * double pyeong = plus/(double)3;  */
		
		
		
		
		String score; 
		score = "";
		score = score + "국어\t영어\t수학\t총점\t평균";
		score = score + "\n"+ kor;  
		score = score + "\t" + eng;
		score = score + "\t" + mat;
		score = score + "\t" + plus;
		score = score + "\t" + pyeon;   //누적 개념. 
		System.out.println(score);
		
		
		
		System.out.printf("국어\t영어\t수학\t총점\t평균\n%d\t%d\t%d\t%d\t%f", kor, eng, mat, plus, pyeon);
		
		
		
		
	}

}
