package com.properties.file.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir"))+"/config.properties");
			properties.load(file);
			System.out.println(properties.getProperty("chromium.browser.args"));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}