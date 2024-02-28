package com.selenium.general.practice;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkWithMultipleWindows {

	public static void main(String[] args) {		
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click Here")));
		driver.findElement(By.linkText("Click Here")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		List<String> windows = driver.getWindowHandles().stream().collect(Collectors.toList());
		System.out.println(driver.switchTo().window(windows.get(0)).getTitle());
		System.out.println(driver.switchTo().window(windows.get(1)).getTitle());
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		driver.quit();
	}

}