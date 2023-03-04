package JavaPrograms;

import java.util.Iterator;
import java.util.Scanner;

public class mathTable {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int no = s.nextInt();
		for (int i=1; i<=10; i++) 
		{
			System.out.printf("%d x %d = %d %n", no,i, no*i);
		}
	}

}
