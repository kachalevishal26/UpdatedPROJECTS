package JavaPrograms;

import java.util.Scanner;

public class sumOfNo 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the array size: ");
		int n = s.nextInt();
		System.out.println("Enter the numbers: ");
		int no[] = new int[n];
		int temp=0;
		for (int i = 0; i < no.length; i++) 
		{
			no[i] = s.nextInt();
		}
		for (int i = 0; i < no.length; i++) 
		{
			temp = temp + no[i];
		}
		System.out.print(temp);
	}
}
