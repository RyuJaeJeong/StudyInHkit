package management;

import java.util.Scanner;

public class ManageEX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Manage mng = new Manage();
		while(true) {
			System.out.println("����(1:��ǰ����, 2:ȸ������, 3:����)");
			int menu = sc.nextInt();
			sc.nextLine();
			if (menu == 3) {
				break;
			}else if (menu == 1) {
				mng.goodManage();
			}else if (menu == 2) {
				System.out.println("ȸ������");
			}else {
				continue;
			}
		}
		
		System.out.println("�ý��� ����");

	}

}
