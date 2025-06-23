package com.selenium.general.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicAuthHandler {
	
	static ChromeDriver driver;
	static ChromeOptions options = new ChromeOptions();
	
	public static void main(String[] args) {		
		options.addArguments("--start-maximized");
	    driver = new ChromeDriver(options);
	    basic_auth("admin", "admin");
	    driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.quit();
		
		options.addArguments("--start-maximized");
	    driver = new ChromeDriver(options);
	    driver.get(basic_auth("admin", "admin", "the-internet.herokuapp.com"));
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.quit();
	}
	
	public static String basic_auth(String username, String password, String hostName) {
		return "https://"+username+":"+password+"@"+hostName+"/";
	}
	
	public static void basic_auth(String username, String password) {
		driver.register(UsernameAndPassword.of(username, password));
	}

}