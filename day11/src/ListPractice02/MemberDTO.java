package ListPractice02;

public class MemberDTO {
//고객정보 클래스
//입력 ; 이름 아이디 구매한 금액	
//출력 ; 이름 아이디	구매한금액 회원등급
//회원등급 : 
	
//field
private String name;
private String id;
private int price;
private String grade;
//cons
public MemberDTO(String name, String id, int price) {
	
	this.name = name;
	this.id = id;		
	this.price = price;
	
	grade();
	
	
}
//method


public void grade () {
	
	if(price>=30000000) {   //등급 판별. 
		grade = "탑스1";
	}else if(price>=10000000) {
		grade = "탑스2";
	}else if(price>=5000000) {
		grade = "탑스3";
	}else {
		grade = "일반";
	}
	display();
}

public void display () {
	System.out.println(name+"("+id+")"+" : " + price + ", " + grade +"등급입니다.");
}

//getter&setter	
	
	
	
}
