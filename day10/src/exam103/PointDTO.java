package exam103;

public class PointDTO {
//Field
private String name;
private int kor;
private int eng;
private int mat;
private int tot;
private double avg;



//private ���� ������, (Modifier)
/*����������
 * private : �ڱ� Ŭ���� �������� �����ϴ�. ���� Ÿ��Ʈ�Ѱ�. 
 * public  : ������ ���°�.
 * protected: ��ӿ��� ���°�~(to be continue)
 * default(=package):�ƹ��͵� �Ⱥپ��ִ°� �� ����Ʈ��. ���� ��Ű�� �������� ��밡��. 
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