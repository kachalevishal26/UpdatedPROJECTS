package com.vk.rahulShetty;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		readExcelData d = new readExcelData();
		ArrayList data = d.getData("Test Cases");
		
		System.out.println(data.get(1));
	}

}
