package exam102;

	public class PointDTO {
	//Field -  �̸� ���� ���� ���� ���� ��� ���
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double avg;
	String grade;
		
		
		
	//Constructor 
	
	public PointDTO() {
		// TODO Auto-generated constructor stub
	}
	
	//Method 	
	public void tot () {
		tot = kor+eng+mat;
	}
	
	public void avg () {	
		avg = tot/3.;
	}
	
	public void grade() {
		if (avg>90) {
			grade = "��";
		} else if (avg>80) {
			grade = "��";
		}else if (avg>70) {
			grade = "��";
		}else if (avg>60) {
			grade = "��";
		}else {
			grade = "��";
		}
	}

	@Override
	public String toString() {
		return "PointDTO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot=" + tot + ", avg="
				+ avg + ", grade=" + grade + "]";
	}

	}
