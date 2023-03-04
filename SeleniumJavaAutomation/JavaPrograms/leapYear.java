package JavaPrograms;

import java.util.Scanner;

public class leapYear {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter year: ");
		long year = s.nextLong();
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			System.out.printf("%d is a leap year", year);
		} else {
			System.out.printf("%d is not a leap year", year);
		}

	}

}
