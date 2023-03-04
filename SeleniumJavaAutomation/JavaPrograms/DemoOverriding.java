package JavaPrograms;

class overriding 
{
	void classA()
	{
		int a=2, b=4;
		int c = a*b;
		System.out.println(c);
	}
}

class overridingProgram2 extends overriding 
{
	void classA()
	{
		super.classA();
		int a=4, b=5;
		int c = a*b;
		System.out.println(c);
	}
}

class DemoOverriding
{
	public static void main(String[] args) 
	{
		overridingProgram2 obj = new overridingProgram2();
		obj.classA();
	}
}