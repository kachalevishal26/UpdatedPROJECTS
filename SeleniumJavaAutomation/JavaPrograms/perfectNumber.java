package JavaPrograms;

import java.util.Scanner;

public class perfectNumber
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int no = s.nextInt();
		int temp = 0;
		for (int i = 1; i < no; i++) 
		{
			if(no % i == 0)
			{
				System.out.println(i);
				temp = temp + i;
			}
		}
		if(temp == no)
		{
			System.out.println("Perfect number");
		}
		else
		{
			System.out.println("Not a perfect number");
		}
	}

}
