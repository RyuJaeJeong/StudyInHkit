package ListPractice03;

import java.util.ArrayList;
import java.util.Scanner;

public class selectEX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Select> arr = new ArrayList<>();
		
		while(true) {
			System.out.println("�����ϼ���(0:����,1:���,2:���)");
			int temp = sc.nextInt();
			if(temp == 0) {         //0�϶� ����
				break;
			}else if(temp == 1) {   //1�϶��� if���� ������.
				if(arr.size()==0) { //����Ʈ�� ����� 0�϶��� 
					System.out.println("--�������--"); //������� ���
				}else {	
					for (int i = 0; i < arr.size(); i++) {	//�׷��� ������ ����Ʈ �����ִ� ��ü�� ���.
						arr.get(i).display();
					}
				}
				
			}else if(temp == 2) {
				arr.add(new Select()); //�⺻�����ڿ����� �̸��� ��ȣ�� �Է¹޴´�. 
			}
		}

	}

}
