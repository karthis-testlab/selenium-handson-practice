package com.selenium.general.practice;

import com.opencsv.bean.CsvBindByName;

public class BaseUrlRepo {
	
	@CsvBindByName(column = "base_url")
	private String url;
	
	public BaseUrlRepo(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	

}