package Test14;

public class exam {

	public static void main(String[] args) {
//		Driver driver = new Driver();
//		
//		Bus bus = new Bus();
//		
//		Taxi taxi = new Taxi();
//		
//		driver.drive(bus);
//		
//		driver.drive(taxi); //�ƱԸ�Ʈ�� �ڽ�, �޾ư��� ����̺� �޼����� �ްԺ����� �θ�. 
		
		//'������'��, ��������(����ʵ�), ��������, �ްԺ��� ��ο��� �̷�� ���� �ִ�.
		
		
		Vehicle vehicle = new Bus();
		vehicle.run();
		Bus bus = (Bus)vehicle;
		
		if(vehicle instanceof Bus) {
			Bus bus1 = (Bus)vehicle;
		} else {
			System.out.println("������ ����ȯ �� �� �����ϴ�.");	
		}
		
		
		
		
		
	}

}
