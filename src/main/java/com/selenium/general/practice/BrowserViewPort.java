package com.selenium.general.practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserViewPort {

	public static void main(String[] args) {
		chromeBrowser("560", "1440");
	}
	
	public static void chromeBrowser(String width, String height) {
		String viewPort = "--window-size=%s,%s";
		ChromeOptions options = new ChromeOptions();
		options.addArguments(viewPort.formatted(width, height));
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/windows");
	}
	
	public static void firefoxBrowser(String width, String height) {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--width="+width);
		options.addArguments("--height="+height);
		FirefoxDriver driver = new FirefoxDriver(options);
		driver.get("https://the-internet.herokuapp.com/windows");
	}
	
	//https://www.selenium.dev/selenium/web/dynamic.html
}