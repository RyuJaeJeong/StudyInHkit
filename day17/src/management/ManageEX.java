package management;

import java.util.Scanner;

public class ManageEX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Manage mng = new Manage();
		while(true) {
			System.out.println("선택(1:상품관리, 2:회원관리, 3:종료)");
			int menu = sc.nextInt();
			sc.nextLine();
			if (menu == 3) {
				break;
			}else if (menu == 1) {
				mng.goodManage();
			}else if (menu == 2) {
				System.out.println("회원관리");
			}else {
				continue;
			}
		}
		
		System.out.println("시스템 종료");

	}

}
