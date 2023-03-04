package JavaPrograms;

import java.util.Scanner;

public class factorsOfNumber 
{
	public static void main(String[] args) 
	{
		Scanner s =  new Scanner(System.in);
		System.out.println("Enter the number: ");
		int no = s.nextInt();
		
		for (int i = 1; i < no; i++) 
		{
			if(no % i == 0)
			{
				System.out.println(i);
			}
		}
	}

}
