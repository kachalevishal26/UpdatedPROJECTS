package JavaPrograms;

import java.util.Scanner;

public class countDigitsInGivenNo 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int no = s.nextInt();
		int r;
		int temp = 0;
		while(no > 0)
		{
			temp = temp + 1;
			no = no / 10;
		}
		System.out.println("Digits are "+temp);
	}

}
