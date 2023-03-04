package JavaPrograms;

import java.util.Scanner;

public class largeNoWithoutArray {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter n number: ");
		int no = s.nextInt();
		System.out.printf("Enter %d numbers: %n", no);
		int largest = 0;
		for (int i = 0; i < no; i++)
		{
			int current = s.nextInt();
			if(current > largest)
			{
				largest  = current;
			}
		}
		System.out.printf("Largest no is %d",largest);
	}
}