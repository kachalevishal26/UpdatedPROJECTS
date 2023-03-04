package com.vk.groupTest;

import org.testng.annotations.Test;

@Test(groups={"all"})
public class ignoreTest2 {
	
	@Test(groups={"sanity"})
	public void test4() {
		System.out.println("Test4");
	}
	
	@Test(groups={"functional"})
	public void test5() {
		System.out.println("Test5");
	}
	
	@Test
	public void test6() {
		System.out.println("Test6");
	}

	@Test(groups={"regression","functional","windows.smoke","windows.sanity","ios.smoke"})
	public void test7() {
		System.out.println("Test7");
	}

}
