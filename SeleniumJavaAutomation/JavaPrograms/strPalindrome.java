package JavaPrograms;

import java.util.Scanner;

public class strPalindrome {
	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the number: ");
//		int no = s.nextInt();
//		int temp = no;
//		int r, sum = 0;
//		
//		while(no<0)
//		{
//			r = no % 10;
//			sum = sum * 10 + r;
//			no = no / 10;
//		}
//		
//		System.out.println(temp);
//		if(temp == no)
//		{
//			System.out.println("Palindrome");
//		}
//		else {
//			System.out.println("Not palindrome");
//		}

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String name = s.nextLine();
		String reverse = "";
		for (int i = name.length() - 1; i >= 0; i--) {
			reverse = reverse + name.charAt(i);
		}
		if (name.equals(reverse)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not palindrome");
		}
	}

}
