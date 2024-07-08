package com.selenium.theadlocal;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeTest {
	
	private static ThreadLocal<RemoteWebDriver> threadLocal = new ThreadLocal<RemoteWebDriver>();

	public static void main(String[] args) {
		
		threadLocal.set(new ChromeDriver());
		getDriver().get("https://www.google.com/");
		getDriver().quit();

	}
	
	public static RemoteWebDriver getDriver() {
		return threadLocal.get();
	}

}