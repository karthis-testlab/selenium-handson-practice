package com.project.test.pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoTest {
	
	@DataProvider
	public String[][] getTestData() {
		return new String[][] {
			{"Sauce Labs Bike Light"},
			{"Sauce Labs Backpack"},
			{"Sauce Labs Onesie"}
		};
	}

	@Test(dataProvider = "getTestData")
	public void main(String eProductName) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		int totalProducts = driver.findElements(By.cssSelector("div.inventory_item")).size();
		String productName = null;
		String price = null;
		for (int i = 0; i < totalProducts; i++) {
			productName = driver.findElements(By.className("inventory_item_name")).get(i).getText();
			if(productName.equals(eProductName)) {
				price = driver.findElements(By.className("inventory_item_price")).get(i).getText();
				driver.findElements(By.xpath("//button[text()='Add to cart']")).get(i).click();
				break;
			}		    
		}
		
		driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		Assert.assertTrue(driver.findElement(By.className("inventory_item_name")).getText().equals(productName));
		Assert.assertTrue(driver.findElement(By.className("inventory_item_price")).getText().equals(price));
		driver.close();

	}

}
