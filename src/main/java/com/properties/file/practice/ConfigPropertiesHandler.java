package com.properties.file.practice;

import java.util.List;

import org.aeonbits.owner.Config;

@Config.Sources("file:./config.properties")
public interface ConfigPropertiesHandler extends Config {
	
	@Key("chromium.browser.args")
	public List<String> getChromiumArgs();

}