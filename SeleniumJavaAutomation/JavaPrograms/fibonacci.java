package JavaPrograms;

import java.util.Iterator;

public class fibonacci {
	public static void main(String[] args) {
		int temp;
		int x = 0;
		int y = 1;
		for (int i = 0; i <= 5; i++) {
			System.out.println(x);
			temp = x + y;
			x = y;
			y = temp;
		}
	}

}
