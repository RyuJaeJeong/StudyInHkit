package exam05;

import java.util.Scanner;

public class TestUnlimitedReceipt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    String name = "";
	    int price = 0;
		String msg = "";
		int total = 0;
		int num = 0;
		int point = 0;
		int totalPoint = 0;
			for (;;) {
			System.out.print("��ǰ���� �Է��� �ּ���.");
			name = sc.nextLine();
			
			if(name.toLowerCase().equals("q")) {
				break;
			}
			System.out.print("��ǰ������ �Է��� �ּ���.");
			price = sc.nextInt();
			sc.nextLine();
			System.out.print("��ǰ ������ �Է��� �ּ���.");
			num = sc.nextInt();
			sc.nextLine();
			int allPrice = num*price;
			total = total + allPrice;
			if (allPrice >=5000) {
				point =  allPrice * 10/100;}
			else {
				point = 0;
			}
			totalPoint = totalPoint + point;
			msg =msg+ name+"..... "+num+"�� ....."+allPrice+"��"+"("+price+"��"+")"+"....."+point+"p"+"\n";
			
			
			}
			System.out.println(msg+"�հ�.........."+total+"........"+totalPoint);
			System.out.println("���α׷� ����");
	}

}
