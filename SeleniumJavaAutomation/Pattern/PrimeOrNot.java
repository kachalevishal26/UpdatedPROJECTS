package Pattern;

import java.util.Scanner;

public class PrimeOrNot {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int no = s.nextInt();
		int count = 0;
		for (int i = 1; i <= no; i++) {
			for (int j = 2; j <= i - 1; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			if(count == 0) {
				System.out.println(i);
			} else {
				count = 0;
			}
		}
	}
}