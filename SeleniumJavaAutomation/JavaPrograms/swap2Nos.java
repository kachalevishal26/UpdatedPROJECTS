package JavaPrograms;

import java.util.Scanner;

public class swap2Nos 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter two numbers: ");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		System.out.println("Before Swap x= "+x+" y= "+y);
		
		/*
		 * Using third variable
		 */
//		int temp;
//		
//		temp = x+y;
//		x = temp-x;
//		y = temp-x;
		
		/*
		 * Without using third variable
		 */
		x = x+y;
		y = x-y;
		x = x-y;
		System.out.println("After Swap x= "+x+" y= "+y);
	}
}
