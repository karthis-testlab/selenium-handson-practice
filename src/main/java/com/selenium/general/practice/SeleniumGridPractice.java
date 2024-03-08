package com.selenium.general.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridPractice {

	public static void main(String[] args) throws MalformedURLException {
		
		ChromeOptions options = new ChromeOptions();
		//options.setCapability("browserVersion", "121.0.6167.184");
		options.setCapability("platformName", "Mac OS X");
		options.setCapability("se:name", "My Selenium Grid test"); 
		options.setCapability("se:sampleMetadata", "Chrome metadata value");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.118:4444"), options);
		driver.get("https://www.google.com");
		driver.quit();
		

	}

}