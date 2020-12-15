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
//		driver.drive(taxi); //아규먼트는 자식, 받아가는 드라이브 메서드의 메게변수는 부모. 
		
		//'다형성'은, 전역변수(멤버필드), 지역변수, 메게변수 모두에서 이루어 질수 있다.
		
		
		Vehicle vehicle = new Bus();
		vehicle.run();
		Bus bus = (Bus)vehicle;
		
		if(vehicle instanceof Bus) {
			Bus bus1 = (Bus)vehicle;
		} else {
			System.out.println("강제로 형변환 할 수 없습니다.");	
		}
		
		
		
		
		
	}

}
