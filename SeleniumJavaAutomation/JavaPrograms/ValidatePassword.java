package JavaPrograms;

import java.util.Scanner;

public class ValidatePassword {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter password: ");
		String s1 = s.nextLine();
		int n = Validation(s1);

		if (n == 1) {
			System.out.println("Valid password");
		} else {
			System.out.println("Invalid password");
		}
	}

	private static int Validation(String s1) {
		// TODO Auto-generated method stub
		if (s1.matches(".*[@#$]{1,}.*") && s1.matches(".*[A-Z]{1,}.*") && s1.matches(".*[a-z]{1,}.*")
				&& s1.matches(".*[0-9]{1,}.*") && s1.length() >= 6 && s1.length() <= 20) {
			return 1;
		} else {
			return 0;
		}
	}
}
