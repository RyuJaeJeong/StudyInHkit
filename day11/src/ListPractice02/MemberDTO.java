package ListPractice02;

public class MemberDTO {
//������ Ŭ����
//�Է� ; �̸� ���̵� ������ �ݾ�	
//��� ; �̸� ���̵�	�����ѱݾ� ȸ�����
//ȸ����� : 
	
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
	
	if(price>=30000000) {   //��� �Ǻ�. 
		grade = "ž��1";
	}else if(price>=10000000) {
		grade = "ž��2";
	}else if(price>=5000000) {
		grade = "ž��3";
	}else {
		grade = "�Ϲ�";
	}
	display();
}

public void display () {
	System.out.println(name+"("+id+")"+" : " + price + ", " + grade +"����Դϴ�.");
}

//getter&setter	
	
	
	
}
