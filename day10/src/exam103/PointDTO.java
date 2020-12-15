package exam103;

public class PointDTO {
//Field
private String name;
private int kor;
private int eng;
private int mat;
private int tot;
private double avg;



//private 접근 제한자, (Modifier)
/*접근제한자
 * private : 자기 클래스 내에서만 가능하다. 가장 타이트한것. 
 * public  : 제한이 없는것.
 * protected: 상속에서 배우는것~(to be continue)
 * default(=package):아무것도 안붙어있는건 다 디폴트임. 같은 패키지 내에서만 사용가능. 
 * */ 

	

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMat() {
			return mat;
		}
		public void setMat(int mat) {
			this.mat = mat;
		}
		public int getTot() {
			return tot;
		}
		public void setTot(int tot) {
			this.tot = tot;
		}
		public double getAvg() {
			return avg;
		}
		public void setAvg(double avg) {
			this.avg = avg;
		}

		


}
