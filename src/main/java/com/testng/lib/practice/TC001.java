package com.testng.lib.practice;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC001 extends TestNGHooks {
	
	@BeforeSuite(alwaysRun = true)
	public void setUp(ITestContext context) {
		System.out.println("Runs @BeforeSuite in the TC001 class");
		context.setAttribute("testDescription", "Validate the functionality of Checkout moudle.");
	}
	
	@Test
	public void tc001() {
		System.out.println("Inside tc001 method.");
	}

}