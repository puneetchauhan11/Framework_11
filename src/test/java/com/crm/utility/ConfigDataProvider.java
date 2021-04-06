package com.crm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	public Properties pro;
	
	public ConfigDataProvider()
	{
		try {
			File src = new File(".//Config//config.proprties");
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception  e) {
			System.out.println("Unable to load Properties file" +e.getMessage());
			
		}
		
		
	}
	
	public String getValue(String Key_to_search)
	{
		return pro.getProperty("Key_to_search");
	}
	
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	
	public String getStageURl()
	{
		return pro.getProperty("qaUrl");
	}
	

}
