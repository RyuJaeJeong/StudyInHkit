package test07;

public class MultiArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 10;
		int[][] array = new int[2][3];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = k;
				k+=10;
			}
		}
		

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println(i+"Çü "+ j+"¿­Àº "+array[i][j]);
			}
		}
		
		
	}

}
