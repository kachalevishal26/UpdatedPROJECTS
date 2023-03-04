package com.vk.test;

import org.testng.annotations.Test;

public class FlightBookingTest {

	@Test(priority = 1)
	public void SignUp() {
		System.out.println("SignUp");
	}

	@Test(priority = 2)
	public void LogIn() {
		System.out.println("LogIn");
	}

	@Test(priority = 3)
	public void SearchForFlight() {
		System.out.println("SearchForFlight");
	}

	@Test(priority = 4)
	public void BooktheFlight() {
		System.out.println("BooktheFlight");
	}

	@Test(priority = 5)
	public void SaveTheTicket() {
		System.out.println("SaveTheTicket");
	}

	@Test(priority = 6)
	public void LogOut() {
		System.out.println("LogOut");
	}

}
