package JavaPrograms;

import java.util.Scanner;

public class EvenOdd 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int no = s.nextInt();
		if(no % 2 == 0)
		{
			System.out.println("Even");
		}
		else
		{
			System.out.println("Odd");
		}
	}
}
