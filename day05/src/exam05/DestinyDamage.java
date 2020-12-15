package exam05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DestinyDamage {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//3회까지 돌려보고 평균 내세요.!!
		long msg =0;
		for(int i = 1; i<=3; i++) {
			System.out.println("총 데미지를 입력하세요 : ");
			long damage = sc.nextLong();
			msg += damage;
		}
		DecimalFormat formatter = new DecimalFormat("#,##0");
		long damage2 = msg/3;
		String damage3 = formatter.format(damage2);
		System.out.print("데미지 평균은 "+damage3+"입니다.");
		
		//데빌로이드 1. 6118619
	    //	      2.6749337
		//	      3.5810124     
		// aver 6,226,026
		//오포이스  1. 4703979
		//         2.4740761
		//3.       3. 4381746
		//4. 4,608,828
		//세멜레 1  5,739,658
		//     2  5,500,626
		//	   3. 5506226
		//
		//5,582,170 악세 치명타
		//악세 세멜레 4649000
		//  5686966
		//5621613
		
		
		
		
		
		
		
	}

}
