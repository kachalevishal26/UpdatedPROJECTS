package com.vk.demoTest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class ignoreTest1 {
	
	@Test(enabled=false)
	public void test1() {
		System.out.println("Test1");
	}
	
	@Ignore
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test3");
	}

}
