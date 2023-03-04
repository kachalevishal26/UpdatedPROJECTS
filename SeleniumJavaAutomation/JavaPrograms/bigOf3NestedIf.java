package JavaPrograms;

import java.util.Scanner;

public class bigOf3NestedIf {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter three numbers: ");
		int x = s.nextInt();
		int y = s.nextInt();
		int z = s.nextInt();
		
		if(x>y)
		{
			if(x>z)
			{
				System.out.printf("%d is greater ",x);
			}
			else
			{
				System.out.printf("%d is greater ",z);
			}
			if(y>z)
			{
				System.out.printf("%d is greater ",y);
			}
			else
			{
				System.out.printf("%d is greater ",z);
			}
		}

	}

}
