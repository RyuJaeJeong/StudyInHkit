package exam02;

public class string_��������_����������� {
public static void main(String[] args) {
	//String : ���ڿ�
//	String insa = "welcome to my site!!!";
//	//String insa = new String("welcome to my site!!!") ��Ʈ���� �⺻�ڷ����� �ƴϴ�.
//	System.out.println(insa);
//	insa = "�ȳ��ϼ���?";
//	System.out.println(insa);
//	insa = "9 * 3 + 2 - 8";
//	System.out.println(insa); //�����ϰ� ���� �����ϴ� ������ ����? ū ����ǥ ""

	//�Լ�
	//�޼ҵ� .length �� ~ �ȿ��� ���̴ϱ� ������ ����������.���� �޼ҵ� 
	
	String alpabet = "abcdefghijklmnopqrstuvwxyz";
	//System.out.println(alpabet.length());  //���̱��ϱ�
	
	//System.out.println("alpabet���� ���̴� " + alpabet.length() + "�Դϴ�.");
//string ���� ���̸� ���Ҽ� �ֱ���. 
	int i = 1234567789;
	//System.out.println(i.length()); ��Ʈ�� Ÿ�Կ��� �������, ������������ ������� ���Ѵ�. 
	
	String txt = "welcome to my site !!!";
			//System.out.println(txt.toUpperCase()); //�빮�ڷ� �ٲٱ�
			
			String txt2 = txt.toUpperCase();
			
			//System.out.println(txt2.toLowerCase()); //�ҹ��ڷ� ���ϱ� 


			//index(�ε���) - ��ġ��, 0���� �����Ѵ�. 
			System.out.println(txt.indexOf("to"));   //8�� �����Ѵ�. �ٸ����� �ִ°��� �ƴϰ� �׳� �����شٴ� ���̴�. 
			System.out.println(txt.length());



String memo1 = "jeong's site !!!";
System.out.println(memo1);

String memo2 = "���� ������ '�뱸' �Դϴ�.";
System.out.println(memo2);

String memo3 = "���� ������ '�뱸'�̸�, \nȸ��� \t'��⵵'�Դϴ�.";   
System.out.println(memo3);


String firstName = "hong";
String lastName = "kildong";
System.out.println(firstName + "\n" +lastName);
System.out.println(firstName.concat(lastName));//.concat() ���ڿ� ���� 

String result = firstName + " " + lastName;

System.out.println(result);

long myNum = 10000000000L;





String str = "happy new year!!!";

System.out.println(str.length());
System.out.println(str.indexOf("n"));




String temp = "010-5657-8990";
String[] temps = temp.split("-");
System.out.println(temps.length);
System.out.println(temps[0]);
System.out.println(temps[1]);
System.out.println(temps[2]);
	}
}
