package day11;

public class time02 {

	public static void main(String[] args) {
		
		
		
		PhoneBook[] pb = new PhoneBook[5]; //객체배열
		pb[0] = new PhoneBook("홍길동", "010-9999-9999"); //우변 매게변수있는 생성자 이용해서 새로운 객체 만들어라, 우변을, 배열 변수에넣어라
		pb[1] = new PhoneBook("류재정", "010-5657-8990");
		pb[2] = new PhoneBook("이지윤", "010-2728-3435");
		pb[3] = new PhoneBook("박정훈", "010-9433-1960");
		pb[4] = new PhoneBook("황상원", "010-9999-9999");
		
		for (int i = 0; i < pb.length; i++) {
			PhoneBook aaa = pb[i];
			System.out.print("\"" + aaa.getName()+",");
			System.out.print(aaa.getPhoneNo()+"\" ");
		}
		
		
		//배열의 복사. 
		
		PhoneBook[] pb2 = new PhoneBook[pb.length*2];
		
		for (int i = 0; i < pb.length; i++) {
			pb2[i] = pb[i];
		}
		pb2 = pb;
		
		System.arraycopy(pb, 0, pb2, 0, pb.length);
	
	}
}
