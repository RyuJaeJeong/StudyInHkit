package exam08;

public class Time05New {
	static void prn(String...a) {
		for (int j = 0; j < a.length; j++) {
			System.out.println("a" + "[" + j + "]" + ":" + a[j]);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// �޼ҵ� �����ε�(overLoading)
		// �޼ҵ� �������̵�(overriding) == �޼ҵ� ������
		
		
		prn("�ڹ�");
		prn("�ڹٴ�", " ��ƴ�.");
		prn("�ڹٴ�"," �ſ� ","��ƴ�.");
		
	}

}
