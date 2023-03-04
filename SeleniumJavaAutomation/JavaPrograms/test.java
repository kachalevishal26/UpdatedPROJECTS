package JavaPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		List<String> l =new ArrayList<>();
		l.add("Vk");
		l.add("Anurag");
		l.add("Karan");
		l.add("Krupal");
		l.add(1,"Jagruti");
		l.add(3,"Shruti");
		System.out.println("List: "+l);
		l.set(0, "Vishal Kachale");
		l.add("Vk1");
		System.out.println("After set: "+l);
		
		Set<String> s = new HashSet<>();
		s.add("Vishal");
		s.add("vishal");
		s.add("Kachale");
		s.add("Vk");
		System.out.println("Set: "+s);
	}
}