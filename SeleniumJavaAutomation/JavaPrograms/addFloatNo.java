package JavaPrograms;

import java.util.Scanner;

public class addFloatNo 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter numbers: ");
		Scanner s = new Scanner(System.in);
		float a = s.nextFloat();
		float b = s.nextFloat();
		float c = a + b;
		System.out.println(c);
	}
}
