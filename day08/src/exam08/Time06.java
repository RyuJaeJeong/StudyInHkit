package exam08;

public class Time06 {
	//Ŭ���� ���ο� ���� 3��
	// <Member> Field (�ʵ�)
	// Constructor (������)
	// Member Method (�޼ҵ�) - ���� �޼ҵ�.
	
	int x = 10;
	int y = 20;
	//���Ⱑ Member Field - Ŭ������ ���Ե� ����.. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Time06 c1 = new Time06();	//c1 ��ü, �ν��Ͻ�
		 System.out.println(c1.x);
		 System.out.println(c1.y);
		 c1.x = 100;
		 
		 System.out.println("c1�� " + c1);
		 
		 c1.y = 200;
		 
		 System.out.println("c1��" + c1.y);
		 
		 Time06 c2 = new Time06();  //c2 ��ü, �ν��Ͻ� 
		 System.out.println(c2.x);
		 System.out.println(c2.y);
	
		 Time06 c3 = new Time06();
		 System.out.println(c3.x);
		 System.out.println(c3.y);
	
	}
	
	

}
