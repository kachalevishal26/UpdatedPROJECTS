package JavaPrograms;

import java.util.Scanner;

public class PrintPerfectNoInGivenRange {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the end range: ");
		int max = s.nextInt();

		for (int i = 1; i <= max; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}
			if (sum == i) {
				System.out.println(i);
			}
		}
	}

}
