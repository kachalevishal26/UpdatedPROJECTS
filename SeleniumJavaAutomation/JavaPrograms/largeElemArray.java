package JavaPrograms;

import java.util.Scanner;

public class largeElemArray {
	public static void main(String[] args) {
		System.out.println("Enter array size: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Enter array elements: ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		int large = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > large) {
				large = arr[i];
			}
		}
		System.out.println("Largest element in array is " + large);
	}
}
