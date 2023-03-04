package JavaPrograms;

import java.util.Scanner;

public class eg {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the year: ");
		int no = s.nextInt();
		if ((no % 400 == 0) || (no % 4 == 0 && no % 100 != 0)) {
			System.out.println("Leap Year");
		} else {
			System.out.println("Not a Leap Year");
		}
	}
}
