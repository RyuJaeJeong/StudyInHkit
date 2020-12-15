package ListPractice03;

import java.util.ArrayList;
import java.util.Scanner;

public class selectEX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Select> arr = new ArrayList<>();
		
		while(true) {
			System.out.println("선택하세요(0:종료,1:목록,2:등록)");
			int temp = sc.nextInt();
			if(temp == 0) {         //0일때 종료
				break;
			}else if(temp == 1) {   //1일때는 if문에 따른다.
				if(arr.size()==0) { //리스트의 사이즈가 0일때는 
					System.out.println("--내용없음--"); //내용없음 출력
				}else {	
					for (int i = 0; i < arr.size(); i++) {	//그렇지 않으면 리스트 내에있는 객체를 출력.
						arr.get(i).display();
					}
				}
				
			}else if(temp == 2) {
				arr.add(new Select()); //기본생성자에서는 이름과 번호를 입력받는다. 
			}
		}

	}

}
