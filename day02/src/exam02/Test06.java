package exam02;

public class Test06 {

	public static void main(String[] args) {
		
		int kor = 83;
		int eng = 93;
		int mat = 81;
		
		int plus = kor + eng + mat;
		double pyeon = plus/(double)3;  //������ ������ �������� ������ ������ ���´� ��ǻ�Ϳ�����. �׷��� ���ʸ� �̶� �Ǽ��� �ٲ��ش�
		
		/* double pyeong = plus/3.0;
		 * double pyeong = (double)plus/3.0;
		 * double pyeong = plus/(double)3;  */
		
		
		
		
		String score; 
		score = "";
		score = score + "����\t����\t����\t����\t���";
		score = score + "\n"+ kor;  
		score = score + "\t" + eng;
		score = score + "\t" + mat;
		score = score + "\t" + plus;
		score = score + "\t" + pyeon;   //���� ����. 
		System.out.println(score);
		
		
		
		System.out.printf("����\t����\t����\t����\t���\n%d\t%d\t%d\t%d\t%f", kor, eng, mat, plus, pyeon);
		
		
		
		
	}

}
