package com.selenium.general.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class ReadUrlFromSiteMap {

	public static void main(String[] args) {

		Document document;

		try {
			document = Jsoup.connect("https://www.java67.com/sitemap.xml").get();
			Elements urls = document.select("sitemap loc");
			List<String> listOfUrls = urls.stream().map(element -> element.text()).collect(Collectors.toList());
			List<BaseUrlRepo> insert = new ArrayList<BaseUrlRepo>();
			for (String url : listOfUrls) {
				insert.add(new BaseUrlRepo(url));
			}
			FileWriter fileWriter = new FileWriter("./data.csv");
			StatefulBeanToCsvBuilder<BaseUrlRepo> builder = new StatefulBeanToCsvBuilder<BaseUrlRepo>(fileWriter);
	        StatefulBeanToCsv<BaseUrlRepo> beanWriter = builder.withApplyQuotesToAll(false).build();
			beanWriter.write(insert);
			fileWriter.close();
		} catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}

	}

}
