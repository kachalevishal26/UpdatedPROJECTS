package JavaPrograms;

import java.util.Scanner;

public class primeNo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no: ");
		int no = s.nextInt();
		int temp = 0;
		for (int i = 1; i <= no; i++) {
			for (int j = 2; j < i - 1; j++) {
				if (i % j == 0) {
					temp = temp + 1;
				}
			}
			if (temp == 0) {
				System.out.println(i);
			} else {
				temp = 0;
			}
		}
	}
}
