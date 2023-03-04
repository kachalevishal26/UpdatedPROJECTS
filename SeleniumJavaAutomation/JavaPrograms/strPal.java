package JavaPrograms;

public class strPal {
	public static void main(String[] args) {
		String name = "madam";
		String rev = "";
		for (int i = name.length() - 1; i >= 0; i--) {
			rev = rev + name.charAt(i);
		}
		if (rev.equals(name)) {
			System.out.println("Palindrome String");
		} else {
			System.out.println("Not Palindrome");
		}
	}
}
