package JavaPrograms;

public class armstrong 
{
	public static void main(String[] args) {
		int n=153, r;
		double sum=0;
		int temp = n;
		while (temp>0) 
		{
			r = temp%10;
			sum = sum+Math.pow(r, 3);
			temp = temp/10;
		}
		if(sum == n)
		{
			System.out.println("Armstrong");
		}
		else
		{
			System.out.println("Not Armstrong");
		}
	}
}
