import java.util.ArrayList;
import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Record2> arr = new ArrayList<>();
		
		while (true) {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		if(name.toLowerCase().equals("q"))
			break;
		System.out.print("국어 : ");
		int lang = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int mat = sc.nextInt();
		sc.nextLine();
		arr.add(new Record2(name,lang,eng,mat));
		}
		
		for (int i = 0; i < arr.size(); i++) {
			arr.get(i).disp();
		}

}
}	
