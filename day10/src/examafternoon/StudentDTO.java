package examafternoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Formatter;

public class StudentDTO {
//field
private String num;
private String name;
private String grade;
private Double credit;
private long money;
//constructor
public StudentDTO() throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("당신의 학번을 입력하세요 : ");
	num = in.readLine();
	System.out.print("당신의 이름을 입력하세요 : ");
	name = in.readLine();
	System.out.print("당신의 학년을 입력하세요 : ");
	grade = in.readLine();
	System.out.print("이번학기 평점을 입력해 주세요 : ");
	credit = Double.parseDouble(in.readLine());
	}
//method	
	public void scholar() {
		DecimalFormat fm = new DecimalFormat("###,###");
		if (credit>=4.5) {
			money = 2000000;
		}else if (credit >=4.0) {
			money = 1500000;
		}else if (credit >= 3.5) {
			money = 1000000;
		}else if (credit >= 3.0) {
			money = 500000;
		}else {
			money = 0; 
		}
	
	System.out.println(num+"\t"+name+"\t"+grade+"\t"+credit+"\t"+fm.format(money)+"원");
	
	
	
	
	
	}




}
