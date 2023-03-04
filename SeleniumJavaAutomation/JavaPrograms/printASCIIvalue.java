package JavaPrograms;

import java.util.Scanner;

public class printASCIIvalue 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the character: ");
		char ch = s.next().charAt(0);
		int asciCh = ch;
		System.out.println("The ASCII value of "+ch+" is "+asciCh);

	}

}
