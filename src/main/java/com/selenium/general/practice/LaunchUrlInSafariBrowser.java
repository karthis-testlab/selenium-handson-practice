package com.selenium.general.practice;

import org.openqa.selenium.safari.SafariDriver;

public class LaunchUrlInSafariBrowser {

	public static void main(String[] args) {
		
		SafariDriver driver = new SafariDriver();
		driver.get("https://www.saucedemo.com/");
		driver.close();

	}

}
