package com.vk.rahulShetty;

import java.io.IOException;
import java.util.ArrayList;

public class dataSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven dd = new dataDriven();
		ArrayList arr = dd.getData("Login");
		
		System.out.println(arr.get(0));
	}

}
