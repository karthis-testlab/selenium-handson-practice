package com.project.test.pratice;

import java.time.Duration;
import java.util.Comparator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ChepOAirTest {
	
	static ChromeDriver driver;

	@Test
	public void testFindLowestPriceInCurrentPage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cheapoair.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.id("onewayTrip")).click();
		//driver.executeScript("arguments[0].click()", driver.findElement(By.id("onewayTrip")));		
		driver.findElement(By.xpath("//input[starts-with(@id,'to')]")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		driver.findElement(By.xpath("//input[starts-with(@id,'to')]")).sendKeys("DEL");
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//li[@data-suggestion='DEL']")));
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[contains(@class,'is--today')]")));
		driver.findElement(By.id("travellerButton")).click();
		driver.findElement(By.id("addadults")).click();		
		driver.findElement(By.id("closeDialog")).click();
		driver.findElement(By.id("searchNow")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[starts-with(@class,'inpathmvp-popup')] ")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'currency') and @title]")));
        Double lowestPrice = driver.findElements(By.xpath("//span[contains(@class,'currency') and @title]")).stream()
              .map(price -> Double.parseDouble(price.getAttribute("title")))
              .distinct()
              .min(Comparator.naturalOrder())
              .get();
        
        System.out.println(lowestPrice);
	}
	
	
	//@Test
	public void testFindLowestPriceInAllPage() {
		/*ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cheapoair.com/air/listing?&d1=BUD&r1=MAA&dt1=02/21/2024&tripType=ONEWAYTRIP&cl=ECONOMY&ad=2&se=0&ch=0&infs=0&infl=0");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));*/
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[starts-with(@class,'inpathmvp-popup')] ")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'currency') and @title]")));
        Double lowestPrice = driver.findElements(By.xpath("//span[contains(@class,'currency') and @title]")).stream()
              .map(price -> Double.parseDouble(price.getAttribute("title")))
              .distinct()
              .min(Comparator.naturalOrder())
              .get();
        
        System.out.println(lowestPrice);
        
	}

}