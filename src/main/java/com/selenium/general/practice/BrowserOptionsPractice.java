package com.selenium.general.practice;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.properties.file.practice.ConfigPropertiesHandler;
import static com.selenium.general.practice.BrowserOptionsPractice.BrowserOptions.*;

public class BrowserOptionsPractice {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");

		System.out.println(options.getCapability("goog:chromeOptions").toString().contains("args=[]"));
		System.out.println(options.getCapability("goog:chromeOptions").toString());
		System.out.println(BrowserOptions.getChromeOptions().getCapability("goog:chromeOptions").toString());

		ChromeDriver driver = new ChromeDriver(getChromeOptions());
		driver.get("https://www.saucedemo.com/");

		EdgeOptions egdeOptions = new EdgeOptions();
		System.out.println(egdeOptions.getCapability("ms:edgeOptions"));

		FirefoxOptions fireFoxOptions = new FirefoxOptions();
		System.out.println(fireFoxOptions.getCapabilityNames());

	}

	public class BrowserOptions {

		private static ConfigPropertiesHandler config = ConfigFactory.create(ConfigPropertiesHandler.class);

		public static ChromeOptions getChromeOptions() {
			ChromeOptions options = new ChromeOptions();
			if (config.getChromiumArgs().size() != 0) {
				options.addArguments(config.getChromiumArgs());
			}
			return options;
		}

	}

}