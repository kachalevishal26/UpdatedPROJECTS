package com.vk.dependencyTest;

import org.testng.annotations.Test;

public class groupDependency {
	
	@Test(groups = "smoke")
	public void demo1() {
		System.out.println("smoke");
	}
	
	@Test(groups = "smoke")
	public void demo2() {
		System.out.println("smoke");
	}
	
	@Test(groups = "smoke")
	public void demo3() {
		System.out.println("smoke");
	}
	
	@Test(groups = "sanity")
	public void demo4() {
		System.out.println("sanity");
	}
	
	@Test(groups = "sanity")
	public void demo5() {
		System.out.println("sanity");
	}
	
	@Test(groups = "regression")
	public void demo6() {
		System.out.println("regression");
	}
	
	@Test(groups = "regression")
	public void demo7() {
		System.out.println("regression");
	}
	
//	@Test(dependsOnGroups = {"smoke","sanity"})
//	public void demo0() {
//		System.out.println("main");
//	}

}
