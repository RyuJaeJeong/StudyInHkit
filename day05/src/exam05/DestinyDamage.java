package exam05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DestinyDamage {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//3ȸ���� �������� ��� ������.!!
		long msg =0;
		for(int i = 1; i<=3; i++) {
			System.out.println("�� �������� �Է��ϼ��� : ");
			long damage = sc.nextLong();
			msg += damage;
		}
		DecimalFormat formatter = new DecimalFormat("#,##0");
		long damage2 = msg/3;
		String damage3 = formatter.format(damage2);
		System.out.print("������ ����� "+damage3+"�Դϴ�.");
		
		//�������̵� 1. 6118619
	    //	      2.6749337
		//	      3.5810124     
		// aver 6,226,026
		//�����̽�  1. 4703979
		//         2.4740761
		//3.       3. 4381746
		//4. 4,608,828
		//���᷹ 1  5,739,658
		//     2  5,500,626
		//	   3. 5506226
		//
		//5,582,170 �Ǽ� ġ��Ÿ
		//�Ǽ� ���᷹ 4649000
		//  5686966
		//5621613
		
		
		
		
		
		
		
	}

}
