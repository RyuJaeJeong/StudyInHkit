package exam01;

public class �ڷ�����_������Ÿ�� {
	public static void main(String[] args) {
/*
		//main method
		System.out.println("�ȳ��ϼ���");
		System.out.println("ȫ�浿");
		System.out.println("3+7 = " + 3+ 7 );
		//3+7 = 37
		System.out.println("3+7 = "+(3+7));
	    //3+7 = 10
		System.out.println("3+7=" + 3*7	);
		System.out.println("3+7 = " + (3*7));
		//���� - �⺻�� ����(primitive type), ������ ���� (reference type)
		
		 * ������ : byte(1byte),short(2byte) int(4byte) long(8byte)
		 * �Ǽ��� : float(4byte), double(8byte)
		 * ������ : char(2byte)
		 * ���� : boolean
		 * 
		 * 1byte = 8bit ==>2**8
		 * 2byte = 16bit ==> 2**16
		 * 4byte = 32bit
		 * 8byte = 64bit 
		 * 00001111
		 
		//�ڷ���, ������Ÿ��
		//number = ������, �����ڰ� �����. 
		//= ����־��, �����ض� , �������� ��, Ȥ�� ���� ����� ������ ������ ��ƶ�. ���Կ�����. 
		//5 : ��
//		int number = 5;
//		System.out.println(number);
System.out.println(Integer.MIN_VALUE);		
System.out.println(Integer.MAX_VALUE);

System.out.println(Short.MIN_VALUE);		
System.out.println(Short.MAX_VALUE);

int number = 5;
number = 10; // �ڷ����� ������ �� ������ �ٽ� �������� �ʽ��ϴ�. 
System.out.println(number);
//���� ���� �� �ʱ�ȭ. 
int su;//���� ���� int su = 100;
su = 100;//�ʱ�ȭ - ������ ó������ ���� ��� ���� �ǹ�. 
System.out.println(su);
int num1 = 20+70//90�� �� ���̴�.!
//------------------------------------------

//int a1,a2,a3;
//int = a1;
//int = a2;
//int = a3;

		byte a = 1;
				System.out.println(a);
				System.out.println(Byte.MAX_VALUE);
				System.out.println(Byte.MIN_VALUE);
				a = 100;
				System.out.println(a);
				a = 127;
				System.out.println(a);
				a = -128;
				System.out.println(a);
				
				float f = 3.14f;
				System.out.println(Float.MIN_VALUE);
				System.out.println(Float.MAX_VALUE);
				
				//�������� �⺻Ÿ���� int�̴�. 
				//�Ǽ����� �⺻Ÿ���� double �̴�. 

				//����   : ����1��
				//���ڿ� : ����1�� �̻�

				
				int number1 = 80;
				int number2 = 90;
				long hab = number1 + number2; // �ڵ�����ȯ(promotion) ���� ������ ���� �� ū ������ �ڷ����� ��������� �ڵ����� ������ 
				short hap = (short)(number1 + number2);//��������ȯ(Casting) ū ������ ���� ���� ������ �ڷ����� �������� �ȵ�����. 
				                                       //�׷��� ������ ���� ���� �ڷ������� �ٲپ� �־��ش�. 
	int j1 = 30;
	int j2 = 50;
	System.out.println(j1 + j2);

	int j3 = j1 + j2;
	System.out.println(j3);  //���� ������ �ɼ��� ª��ª�� ���� ���� ����. 
	
	int j4 = j1 - j2;
	System.out.println(j4);

	int j5 = j1*j2;
	System.out.println(j5);
	
	j1 = 7;
	j2 = 2;
	
	
	int j6 = j1/j2;
	System.out.println(j6);
	
//������ ������ �����ϸ� ����� ������ ������ ���´�. 

	int j7 = j1%j2; //������ ���ϴ°�. 
	System.out.println(j7);
	
	//�������. */
	
	String str1 = "����";
	//System.out.print(str1);  //������ ����
	//String str1 = new String("����");  ������ ����, �굵 Ŭ������ .

	
	String str2 = "�α�";
	//System.out.println(str2);
	
	System.out.println(str1+str2);
	
	//���ڿ� + ���ڿ� => �����Ǽ� ���´�.
	
	
	str1 = "6";
			str2 = "7";
	int nu1 = 2;
	
	System.out.println(str1 + str2 + nu1);
	
	//���ڿ� + ���ڿ� + ����(�ڵ����� ���𿭷� �ٲ��.) 
	
	//���� - ������ ������� ����� �ȴ�. 
	// �ڷ��� �����̸� = �� �Ǵ� ��;
	//�����̸��� ù ���ڴ� ����������� �ʴ´�
	//�����̸��� ù���ڷ� _(�����), $(�޷�ȭ)�� �����ϴٰ� �Ѵ�. ������ �ϴٸ� ���� ���� ����. 
	
	String n1ame = "ȫ�浿";
	String _nme = "ȫ�浿";
	String $nme = "ȫ�浿";
	
	char a = 3;
	System.out.println(a+3);
	
	}
}
