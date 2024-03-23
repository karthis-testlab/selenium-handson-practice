package com.testng.lib.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestNGHooks {
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("Runs @BeforeSuite in the TestNGHooks class");
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("Runs @BeforeClass in the TestNGHooks class");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("Runs @AfterClass in the TestNGHooks class");
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("Runs @AfterSuite in the TestNGHooks class");
	}

}