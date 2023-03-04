package JavaPrograms;

import java.util.Scanner;

public class arrayData {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the array size: ");
		int n = s.nextInt();
		System.out.println("Enter the data");
		int no[] = new int[n];
		for (int i = 0; i < n; i++) {
			no[i] = s.nextInt();
		}

		for (int i = 0; i < no.length; i++) {
			System.out.println(no[i]);
		}
	}
}
