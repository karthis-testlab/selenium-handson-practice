package com.project.test.pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//span[contains(@class,'CalendarDaysSpan')]
		driver.findElement(By.id("onwardCal")).click();
		
		System.out.println(driver.findElement(By.xpath("//span[text()='10']")).getCssValue("color"));
		System.out.println(driver.findElement(By.xpath("//span[text()='10']")).getCssValue("background-color"));

	}

}
