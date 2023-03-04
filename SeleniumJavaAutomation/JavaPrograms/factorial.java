package JavaPrograms;

import java.util.Scanner;

public class factorial {
	public static void main(String[] args) {

		
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		int fact = 1;
		for (int i = 1; i <= number; i++) {
			fact = fact * i;
			System.out.println(fact);
		}
	}
}
