package exam10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonDTOEx {

	public static void main(String[] args) throws IOException {
		//1. ��ü�� �����Ѵ�. 
		//2. ������ ���� �Է¹޾ƾ��Ѵ�. Ȥ�� ��ü�����߿� �Է��� ���� �޾ƾ��� �����ִ�.
		//2.5 ����. 
		//3. ��ü�� ����ִ´�.
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�̸� : ");
		String name = in.readLine();
		
		System.out.println("���� : ");
		int age = Integer.parseInt(in.readLine());
		
		System.out.println("Ű : ");
		double height = Double.parseDouble(in.readLine());
		
		System.out.println("������ : ");
		double weight = Double.parseDouble(in.readLine());
		
		
		//xml, json ��� �ϸ� �����͸� ���� �� ���� ������?
		
		
		//PersonDTO p1 = new PersonDTO();
		//�⺻ �����ڸ� �̿��ϰڴٴ� �̾߱�.
		
		PersonDTO p2 = new PersonDTO(name, age, height, weight);
		//�Ű������� �̿��ؼ� ��ü�� �����Ѵ�. 
		
		
		
		
	}

}
