package JavaPrograms;

import java.util.Scanner;

public class arrayTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		2*3
		int[][] no = new int[2][3];
		no[0][0] = 46;
		no[0][1] = 28;
		no[0][2] = 5;
		no[1][0] = 91;
		no[1][1] = 53;
		no[1][2] = 12;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(no[i][j]);
			}
		}
	}
}
