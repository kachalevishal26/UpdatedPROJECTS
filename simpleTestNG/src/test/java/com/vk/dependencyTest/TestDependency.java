package com.vk.dependencyTest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestDependency {
	static String trackNumber = null;
	
	@Test()
	public void createShipment() {
//		System.out.println(5/0);
		System.out.println("createShipment");
		trackNumber = "H2D097V6CA";
	}

	@Test(dependsOnMethods = {"createShipment"},ignoreMissingDependencies = true)
	public void trackShipment() throws Exception {
		if(trackNumber != null)
			System.out.println("trackShipment");
		else
			throw new Exception("Invalid track number!");
	}

	@Test(dependsOnMethods = {"createShipment","trackShipment"})
	public void cancelShipment() throws Exception {
		if(trackNumber!=null)
			System.out.println("cancelShipment");
		else
			throw new Exception("Invalid track number");
	}
}
