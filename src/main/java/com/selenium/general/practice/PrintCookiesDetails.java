package com.selenium.general.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintCookiesDetails {

	static ChromeDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		driver.manage().getCookies().stream().forEach(x -> {
			System.out.println(x.getName());
			System.out.println(x.getValue());
			System.out.println(x.getPath());
			System.out.println(x.getDomain());
			System.out.println(x.getExpiry());
			System.out.println(x.isSecure());
			System.out.println(x.isHttpOnly());
		});

	}

}