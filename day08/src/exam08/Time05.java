package exam08;

public class Time05 {
	static void prn(String[] n) { //parameter
		n[2] = "��ö��";
		System.out.println(n[2]);
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i] + " �̰��� prn");
		}
	}
	
	
	
	public static void main(String[] args) {
		String[] names = {"ȫ�浿", "�̼���", "��õ��", "�̻��"};
		prn(names); //prn�̶�� �޼��忡 names��� ���ڿ� �迭�� ����־� �����ض�. �ƱԸ�Ʈ 
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "����� ���θ޼���");
		}
	}

}
