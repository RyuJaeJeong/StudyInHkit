package exam05;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		//�ݺ��� : for. while, do ~ while
		
Scanner sc = new Scanner(System.in);

System.out.print("���ڸ� �Է��ϼ��� : ");

int num = sc.nextInt();
int msg1 = 0;
int msg2 = 0;
int msg = 0;
while(num--!=1) { //���� ������. ������ ���� �� �����.
	if(num%2==0) {
		msg1 = msg1 + num;
	}else {
		msg2 = msg2 + num;
		
	} 
	 msg = msg1 + msg2;
	 
}

System.out.println("�� �հ�� " + msg + "�Դϴ�." );
System.out.println("¦���� �� �հ�� " + msg1 + "�Դϴ�." );
System.out.println("Ȧ���� �� �հ�� " + msg2 + "�Դϴ�." );
//�Է� ; ����
//��� : 1~�������� �հ�
//1~�������� ¦���հ�
//1~�������� Ȧ���հ�
	
	
	
	

	
	
	//while��. ������ �� ����. ���� ������ �� ��������. 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
