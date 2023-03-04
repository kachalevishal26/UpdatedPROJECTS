package JavaPrograms;

import java.util.Scanner;

public class bigOf3LadderIf {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter three numbers: ");
		int x = s.nextInt();
		int y = s.nextInt();
		int z = s.nextInt();
		if(x > y && x > z)
		{
			System.out.printf("%d is greater", x);
		}
		else if(y > z)
		{
			System.out.printf("%d is greater", y);
		}
		else
		{
			System.out.printf("%d is greater", z);
		}
	}

}
