import java.util.Scanner;

public class eg {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int x = s.nextInt();
		System.out.println("Before " + x);
		int temp = x;
		int r = 0;
		int sum = 0;
		while (temp > 0) {
			r = temp % 10;
			sum = (sum * 10) + r;
			temp = temp / 10;
		}
		System.out.println("After " + sum);
	}
}
