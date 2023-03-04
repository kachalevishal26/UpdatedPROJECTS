package Interviews;

import java.util.Scanner;

interface learnInterface {
	void input();

	void output();
}

abstract class vk implements learnInterface {
	String uName;
	Double pWd;

	public void input() {
		Scanner s = new Scanner(System.in);
		uName = s.next();
		pWd = s.nextDouble();
	}

	public void output() {
		System.out.println("Username is " + uName);
		System.out.println("Password is " + pWd);
	}
}