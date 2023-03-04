package com.vk.dataProvider;

import org.testng.annotations.DataProvider;

public class dataSupplierClass {
	
	@DataProvider
	public String[] typeTest() {
		String[] data = new String[] {
				"Vishal",
				"Karan",
				"Krupal",
				"Twinkal"
		};
		return data;
		
	}

}
