package exam02;

public class Test05 {

	public static void main(String[] args) {
		// ����ȯ : �ڵ�����ȯ(Promotion), ��������ȯ(Casting)
		//        ����������ȯ                    ���������ȯ
		// �ϳ��� Ÿ���� �ٸ� Ÿ������ �ٲٴ� ��. 
		//��������� ���� Ÿ�Կ��� ū Ÿ�������� Ÿ�Ժ�ȯ�� ������ �� �ֽ��ϴ�.
		//ū Ÿ�Կ��� ���� Ÿ�������� Ÿ�� ��ȯ�� ������ �ս��� �߻��մϴ�. 
		
		
		
		int intValue = 7;
		double doublevalue = 3.0;   // �ڵ�����ȯ
		doublevalue = intValue;
		System.out.println(doublevalue);
		
		
		//long : 8byte
		//double : 8byte 
		
		double dValue1 = 8.53;
		int iValue1 = 5;
		iValue1 = (int)dValue1;
		System.out.println(iValue1);
		//0.53�� ���ǵǾ���. �ɼ� ������ �̷��� �Ⱦ��� ���� ���� ����. 
		
		
		System.out.println(Byte.MIN_VALUE +" ~ "+ Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE +" ~ "+ Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE +" ~ "+ Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE +" ~ "+ Long.MAX_VALUE);
		System.out.println(Float.MIN_VALUE +" ~ "+ Float.MAX_VALUE);
		System.out.println(Double.MIN_VALUE +" ~ "+ Double.MAX_VALUE);
		int i1 = 130;
		byte b1 = (byte)i1;
		System.out.println(b1);   //�̷� ������ �츮�� ���� ���ϴ� ���� �����⵵ �ϴϱ� ��.��.�� ������ �Ѵ�. 
		
		long a = 123L;
		
		float bb = 123f; 
		
		
		
	}

}
