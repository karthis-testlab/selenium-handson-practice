package com.selenium.general.practice;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthHandler {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/guide/selenium-scroll-tutorial");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

}