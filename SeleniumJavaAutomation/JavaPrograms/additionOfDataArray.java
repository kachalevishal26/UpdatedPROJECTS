package JavaPrograms;

import java.util.Scanner;

public class additionOfDataArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the array no: ");
		int n = s.nextInt();
		System.out.println("Enter the numbers: ");
		int no[] = new int[n];
		int temp=0;
		for (int i = 0; i < n; i++) {
			no[i] = s.nextInt();
			temp = temp + no[i];
		}
		System.out.println("Sum is "+temp);
	}
}
