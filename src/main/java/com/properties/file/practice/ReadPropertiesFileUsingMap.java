package com.properties.file.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class ReadPropertiesFileUsingMap {

	public static void main(String[] args) {		
		System.out.println(getValueInProperties("config", "chromium.browser.args"));
		System.out.println(getValueInProperties("config", "chromium.browser.arg"));
	}
	
	public static String getValueInProperties(String fileName, String key) {
		String value = null;
		Properties properties = new Properties();
		Map<String, String> map = new LinkedHashMap<String, String>();
		try {
			FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir"))+"/"+fileName+".properties");
			properties.load(file);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		for(Entry<Object, Object> entry: properties.entrySet()) {
			map.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
		}
		if(map.containsKey(key)) {
			value = map.get(key);
		} else {
			throw new RuntimeException("Unable to found give "+key+" key in the "+fileName+".properties file.");
		}
		return value;
	}

}