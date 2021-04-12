package day3;

public class day3 {
	public static void main(String[] args) {
		/*
		 * int i; int sum = 0;
		 * 
		 * for (i = 1; i <= 5; ++i) { sum += i; System.out.printf("%d, %d\n", i, sum); }
		 */
		
		/*
		 * int a=3, b=4, c=5, d=5;
		 * 
		 * a += 6 + --b;
		 * 
		 * d *= 7 - c++;
		 * 
		 * System.out.printf("%d, %d, %d, %d\n", a, b, c, d );
		 */
		
		/*
		 * int k = 0, hap = 0;
		 * 
		 * do { ++k; hap += k; } while (k < 5); { System.out.printf("%d, %d\n", k, hap);
		 * }
		 
		 */
		
		int a, s = 0;
		
		for (a = 1; a <= 3; ++a, s += a) {
			System.out.printf("%d, %d\n", a, s);
		}
		
		
	}
}
