package JavaPrograms;

import java.util.Scanner;

public class noPrimeOrNot {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int no = s.nextInt();
		int count = 1;

		for (int i = 1; i < no; i++) {
			if (no % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			System.out.println("Prime number");
		} else {
			System.out.println("Not a prime number");
		}
	}
}
