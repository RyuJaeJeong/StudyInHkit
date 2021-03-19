package day2;

public class day2 {
	public static void main(String[] args) {
		byte b = 1;
		short s = 2;
		char c = 'A';
		
		int finger = 10;
		long big = 100_000_000_000L;
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;
		
		int octNum = 010;	// 8진수 10, 10진수로는 8
		int hexNum = 0x10;	//16진수 10, 10진수로는 16
		int binNum = 0b10;	//2진수 10, 10진수로는 2
		
		
		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);	//%d 10진 정수의 형식으로 출력
		System.out.printf("c=%c, %d %n", c, (int)c );
		
		System.out.printf("finger=[%5d]%n", finger);
		System.out.printf("finger=[%-5d]%n", finger);
		System.out.printf("finger=[%05d]%n", finger);
		
		System.out.printf("big = %d%n", big);
		System.out.printf("hex=%#x%n", hex); //%x 16진 정수 형식으로 출력 '#' 은 접두어 
		System.out.printf("octNum=%o, %d%n", octNum, octNum); // %o 는 8진 정수 형식으로 출력
		System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);	
		System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum); // %s 는 문자열로 출력.
		
		
	}
}
