package com.project.test.pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IntelligentlyAppTest extends TestNGHooks {
	
	@BeforeMethod
	public void beforeMethod() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("userName")));
		driver.findElement(By.id("userName")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//div[starts-with(@class,'login-btn')]//button[@type]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[starts-with(@class,'loaderquickly')]/following-sibling::div[text()='LOGGING IN...']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[starts-with(@class,'loaderquickly')]/following-sibling::div[text()='LOGGING IN...']")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Application is loading' and @class='largetext']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Application is loading' and @class='largetext']")));
	}
	
	@Test
	public void testcase1() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[normalize-space(text())='My Quotes']")));
		Assert.assertTrue(driver.findElement(By.id("tabset")).isDisplayed());
		driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']/tr[1]/td[3]//span/span")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='PRICING INFORMATION']")));
		driver.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[text()='PRICING INFORMATION']")));
		driver.findElement(By.xpath("//span[text()='PRICING INFORMATION']/preceding-sibling::div/i")).click();
		Select exchangeRate = new Select(driver.findElement(By.xpath("//p-accordion[contains(@class,'editSectionAccordion')]//select")));
		exchangeRate.selectByValue("31st of Month");
	}

}