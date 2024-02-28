package com.project.test.pratice;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class TestNGHooks {
	
	protected RemoteWebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

}