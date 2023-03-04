package JavaPrograms;

import java.util.Scanner;

public class bigOf3No 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter three numbers: ");
		int x = s.nextInt();
		int y = s.nextInt();
		int z = s.nextInt();
		int res = (x>y) ? (x>z ? x:z) : (y>z ? y:z);
		System.out.printf("Max no is %d", res);
//		if(x > y && x > z)
//		{
//			System.out.printf("%d is largest ", x);
//		}
//		else if(y > z)
//		{
//			System.out.printf("%d is largest ", y);
//		}
//		else 
//		{
//			System.out.printf("%d is largest ", z);
//		}
	}
	
}
