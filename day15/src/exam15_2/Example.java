package exam15_2;

public class Example {

	public static void main(String[] args) {
		InterfacePR a;
		
		//(�ŰԺ���) -> (���๮);
		a = (x, y) -> {
			System.out.println(x + y +3);
		}; 
		a.method01(3,2); //�̰��� ����. ����Ŭ������ ��ü ���� ��ȸ�� �Լ��� �����°�. 
	}

}
