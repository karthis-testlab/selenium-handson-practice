package com.selenium.general.practice;

import org.openqa.selenium.chrome.ChromeDriver;

public class FullPageScreenShot {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

}