package com.selenium.general.practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;
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
		String parentHandle = driver.getWindowHandle();
		driver.get("https://the-internet.herokuapp.com/windows");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click Here")));
		driver.findElement(By.linkText("Click Here")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		switchNewWindowByWindowHandle(driver, parentHandle);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		driver.close();
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		switchToParentWindow(driver, parentHandle);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		driver.quit();
		
	}
	
	public static void switchToParentWindow(ChromeDriver driver, String parentWindow) {
		driver.switchTo().window(parentWindow);
	}
	
	public static void switchNewWindowByTitle(ChromeDriver driver, String title) {		
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(title)) {				
				break;
			}
		}
	}
	
	public static void switchNewWindowByWindowHandle(ChromeDriver driver, String parentHandle) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if(!window.equals(parentHandle)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
	/*
	 * List<String> windows = driver.getWindowHandles().stream().collect(Collectors.toList());
		System.out.println(driver.switchTo().window(windows.get(0)).getTitle());
		System.out.println(driver.switchTo().window(windows.get(1)).getTitle());
		driver.switchTo().window(windows.get(1));
	 */

}