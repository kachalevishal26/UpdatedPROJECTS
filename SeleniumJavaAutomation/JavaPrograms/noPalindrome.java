package JavaPrograms;

public class noPalindrome {
	public static void main(String[] args) {
		int no = 15151, sum = 0, remNo;
		int r;
		int temp = no;
		while (no > 0) {
			r = no % 10;
			sum = (sum * 10) + r;
			no = no / 10;
		}
		if (temp == sum) {
			System.out.println("Palindrome No");
		} else {
			System.out.println("Not Palindrome");
		}
	}
}
