package day11;

public class time02 {

	public static void main(String[] args) {
		
		
		
		PhoneBook[] pb = new PhoneBook[5]; //��ü�迭
		pb[0] = new PhoneBook("ȫ�浿", "010-9999-9999"); //�캯 �ŰԺ����ִ� ������ �̿��ؼ� ���ο� ��ü ������, �캯��, �迭 �������־��
		pb[1] = new PhoneBook("������", "010-5657-8990");
		pb[2] = new PhoneBook("������", "010-2728-3435");
		pb[3] = new PhoneBook("������", "010-9433-1960");
		pb[4] = new PhoneBook("Ȳ���", "010-9999-9999");
		
		for (int i = 0; i < pb.length; i++) {
			PhoneBook aaa = pb[i];
			System.out.print("\"" + aaa.getName()+",");
			System.out.print(aaa.getPhoneNo()+"\" ");
		}
		
		
		//�迭�� ����. 
		
		PhoneBook[] pb2 = new PhoneBook[pb.length*2];
		
		for (int i = 0; i < pb.length; i++) {
			pb2[i] = pb[i];
		}
		pb2 = pb;
		
		System.arraycopy(pb, 0, pb2, 0, pb.length);
	
	}
}
