package test07;

import java.util.Scanner;

public class MulArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int [][] nums = {{1,2,3,},{4,5,6},{7,8,9}};
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.println(i+"행 "+j+"열의 값은"+nums[i][j]);
			}
			System.out.println();
		}

	}

}
