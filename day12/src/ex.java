import java.util.ArrayList;
import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Record2> arr = new ArrayList<>();
		
		while (true) {
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		if(name.toLowerCase().equals("q"))
			break;
		System.out.print("���� : ");
		int lang = sc.nextInt();
		System.out.print("���� : ");
		int eng = sc.nextInt();
		System.out.print("���� : ");
		int mat = sc.nextInt();
		sc.nextLine();
		arr.add(new Record2(name,lang,eng,mat));
		}
		
		for (int i = 0; i < arr.size(); i++) {
			arr.get(i).disp();
		}

}
}	
