package com.project.test.pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		int rowSize = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colSize = driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th")).size();
		for (int i = 1; i < rowSize; i++) {
			for (int j = 1; j <= colSize; j++) {
				if(driver.findElement(By.xpath("//table[@id='customers']//tr["+(i+1)+"]/td["+j+"]")).getText().equals("Mexico")) {
					System.out.println(driver.findElement(By.xpath("//table[@id='customers']//tr["+(i+1)+"]/td[1]")).getText());
					break;
				}
			}
		}

	}

}
