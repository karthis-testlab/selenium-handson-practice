package com.project.test.pratice;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;

public class RedBus {
	
	private static ChromeDriver driver;

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("onwardCal")).click();	

		System.out.println(getWeekEndsOfMonth("Mar 2024"));
		
		driver.close();

	}

	public static List<String> getWeekEndsOfMonth(String monthAndYear) {
		
		while (!driver.findElement(By.xpath("//div[contains(@class,'CalendarHeader')]/div[text()]")).getText()
				.startsWith(monthAndYear)) {
			System.out.println(driver.findElement(By.xpath("//div[contains(@class,'CalendarHeader')]/div[text()]")).getText());
			if (driver.findElements(By.cssSelector("div.holiday_count")).size() == 0) {
				System.out.println("0 Holidays");
			}
			
			List<WebElement> monthChanger = driver
					.findElements(By.xpath("//div[contains(@class,'CalendarHeader')]/div/*[@id]"));
			
			if (monthChanger.size() > 1) {
				monthChanger.get(1).click();
			} else {
				monthChanger.get(0).click();
			}
			
		}		
		
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'CalendarHeader')]/div[text()]")).getText());
		
		if (driver.findElements(By.cssSelector("div.holiday_count")).size() == 0) {
			System.out.println("0 Holidays");
		}

		List<String> weekEnds = driver.findElements(By.xpath("//span[contains(@class,'CalendarDaysSpan')]")).stream()
				.filter(element -> Color.fromString(element.getCssValue("color")).asHex().equals("#d84e55"))
				.map(element -> element.getText()).collect(Collectors.toList());

		if (istodayWeekEnd(monthAndYear)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d");
			weekEnds.add(0, dateFormat.format(new Date()));
		}
		
		return weekEnds;
	}

	public static boolean istodayWeekEnd(String monthAndYear) {
		boolean rBoolean = false;
		String[] strings = monthAndYear.split(" ");
		
		if(LocalDate.now().getMonth().toString().startsWith(strings[0].toUpperCase()) && LocalDate.now().getYear() == Integer.parseInt(strings[1])) {
			rBoolean = LocalDate.now().getDayOfWeek().toString().equalsIgnoreCase("SATURDAY")
					   || LocalDate.now().getDayOfWeek().toString().equalsIgnoreCase("SUNDAY");
		}			
		
		return rBoolean;
	}

}
