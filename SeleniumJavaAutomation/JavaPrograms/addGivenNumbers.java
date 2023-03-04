package JavaPrograms;

import java.util.Scanner;

public class addGivenNumbers 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int no = s.nextInt();
		int sum = 0;
		for (int i = 1; i <= no; i++) 
		{
			sum = sum+i;
		}
		System.out.println(sum);
	}
	
}
