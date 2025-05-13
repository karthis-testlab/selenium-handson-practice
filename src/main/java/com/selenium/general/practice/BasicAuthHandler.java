package com.selenium.general.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicAuthHandler {
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		driver.register(UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println(driver.findElement(By.tagName(""));
	}

}