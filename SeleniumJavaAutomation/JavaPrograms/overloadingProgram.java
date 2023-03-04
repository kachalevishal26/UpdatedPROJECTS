package JavaPrograms;

public class overloadingProgram {
	public void classA(String name) {
		System.out.println("Method-A");
	}

	public void classA(String name, int age) {
		System.out.println("Method-B");
	}

	public static void main(String[] args) {
		overloadingProgram obj = new overloadingProgram();
		obj.classA("Vishal");
		obj.classA("Vk", 24);
	}
}