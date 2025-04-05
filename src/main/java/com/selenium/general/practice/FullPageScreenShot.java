package com.selenium.general.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v133.page.Page;

public class FullPageScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flexcarestaff.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Page.enable());
		String screenshotBase64 = devTools.send(Page.captureScreenshot(
				Optional.of(Page.CaptureScreenshotFormat.PNG), 
				Optional.empty(), 
				Optional.empty(),
		        Optional.empty(), 
		        Optional.of(true), 
		        Optional.empty()));
		byte[] decodeScreenshot = Base64.getDecoder().decode(screenshotBase64);
        Files.write(Paths.get("fullpage_devtools.png"), decodeScreenshot);
        driver.quit();
		
	}

}