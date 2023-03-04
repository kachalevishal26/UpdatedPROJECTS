package com.vk.dataProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parameterDataType {

	@Test(dataProvider = "typeTest", dataProviderClass = dataSupplierClass.class)
	public void testParameterType(String s)  {
		
			System.out.println(s);
		
	}
	
// We will take same data from another class.
	
//	@DataProvider
//	public String[] typeTest() {
//		String[] data = new String[] {
//				"Vishal",
//				"Karan",
//				"Krupal",
//				"Twinkal"
//		};
//		return data;
//		
//	}
	
//	@DataProvider
//	public Iterator<Object> typeTest() {
//	Set<Object> data = new HashSet();
//	data.add(new Object[] {"Vishal",123});
//	data.add(new Object[] {"Kachale",456});
//	
//	return data.iterator();
//	}
	
//	@DataProvider
//	public Iterator<String> typeTest() {
//	Set<String> data = new HashSet();
//	data.add("Vishal");
//	data.add("Kachale");
//	
//	return data.iterator();
//	}
	
//	@DataProvider
//	public Iterator<String> typeTest() {
//	List<String> data = new ArrayList<>();
//	data.add("Vishal");
//	data.add("Kachale");
//	
//	return data.iterator();
//	}
	
	
	
	
//	@DataProvider
//	public String[][] typeTest() {
//		String[][] data = new String[][] {
//				{"Vishal","123"},
//				{"Karan","231"},
//				{"Onkar","212"},
//				{"Krupal","106"}
//		};
//		return data;
//		
//	}

//	@DataProvider
//	public Integer[] typeTest() {
//		Integer[] data = new Integer[] {
//				123,
//				456,
//				234,
//		};
//		return data;
//		
//	}
	
//	@DataProvider
//	public String[] typeTest() {
//		String[] data = new String[] {
//				"Vishal",
//				"Karan",
//				"Krupal",
//				"Twinkal"
//		};
//		return data;
//		
//	}

}
