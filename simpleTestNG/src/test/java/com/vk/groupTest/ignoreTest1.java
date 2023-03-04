package com.vk.groupTest;

import org.testng.annotations.Test;

@Test(groups={"all"})
public class ignoreTest1 {
	
	@Test(groups={"smoke","windows.smoke"})
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(groups={"smoke","sanity","functional","windows.sanity","ios.smoke"})
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(groups={"regression","windows.smoke","windows.sanity"})
	public void test3() {
		System.out.println("Test3");
	}

}
