package com.selenium.general.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkWithBasicAuth {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("p")));       
		String pageMessage = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(pageMessage);
		driver.close();
	}

}
