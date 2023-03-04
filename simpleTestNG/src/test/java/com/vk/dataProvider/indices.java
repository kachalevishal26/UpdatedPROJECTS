package com.vk.dataProvider;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class indices {
	
	@Test(dataProvider = "typeTest")
	public void testParameterType(String s)  {
		
			System.out.println(s);
		
	}
	
	@DataProvider(indices = {0,2,5})
	public String[] typeTest() {
	String[] data = new String[] {
		"Vishal",
		"Krupal",
		"Onkar",
		"Smeet",
		"Karan",
		"Abhishek"
	};
	return data;
	}

}
