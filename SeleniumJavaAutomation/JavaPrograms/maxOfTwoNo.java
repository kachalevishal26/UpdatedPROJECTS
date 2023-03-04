package JavaPrograms;

public class maxOfTwoNo 
{
	public static void main(String[] args) 
	{
		int i=24, j=20, k=112;
		
		//Two number
//		int max = (i>j) ? i : j;
		
		int max = (i>j) ? (i>k?i:k) : (j>k?j:k);
		System.out.println(max);
//		if(i>j)
//		{
//			System.out.println("Max is i");
//		}
//		else 
//		{
//			System.out.println("Max is j");
//		}
//		
	}
}
