package JavaPrograms;

public class CapAndSmall {
	public static void main(String[] args) {
		String name = "Welcome To Automation";
		int upper = 0;
		int lower = 0;

		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				upper++;
			} else if (ch >= 'a' && ch <= 'z') {
				lower++;
			}
		}
		System.out.println(upper + " " + lower);
	}
}
