package JavaPrograms;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class stringProg 
{
	public static void main(String[] args) {
		String names = "Vishal, Karan, Lakhan, Rohit, Virat";

		String[] arrOfStr = names.split(",");
		for (String a : arrOfStr) 
		{
			System.out.println(a);
		}
	}
}
