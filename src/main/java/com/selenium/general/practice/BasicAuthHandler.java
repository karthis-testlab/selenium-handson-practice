package com.selenium.general.practice;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicAuthHandler {
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://www.browserstack.com/guide/selenium-scroll-tutorial");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

}