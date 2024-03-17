package com.project.test.pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartTest {

	//Handle Hidden Drop Down Values / Auto Suggestions using DOM Trick | EventListener
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.get("https://www.flipkart.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")))
		        .sendKeys("MacBook Air");		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/ul/li")));
		driver.findElements(By.xpath("//form/ul/li//a"))
		      .stream()
		      .map(element -> element.getText().trim())
		      .forEach(System.out::println);
		
		driver.close();
		

	}

}
