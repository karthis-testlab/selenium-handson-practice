package com.testng.lib.practice;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC002 extends TestNGHooks {
	
	@BeforeSuite(alwaysRun = true)
	public void setUp(ITestContext context) {
		System.out.println("Runs @BeforeSuite in the TC002 class");
		context.setAttribute("testDescription", "Validate the functionality of Add to cart moudle.");
	}
	
	@Test
	public void tc002() {
		System.out.println("Inside tc002 method.");
	}

}