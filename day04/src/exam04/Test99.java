package exam04;

public class Test99 {

	public static void main(String[] args) {
		int i;
		int j;
		
		for( i=2; i<=9; i++) {
			System.out.println("===="+i+"´Ü"+"====");
			for( j=1; j<=9; j++) {
				String i2 = Integer.toString(i);
				String j2 = Integer.toString(j);
				System.out.println(i2+"*"+j2+"="+i*j);
			}
			
		}

	}

}
