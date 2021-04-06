package com.crm.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	// Scereenshots , Alerts, frames, sync issue , javascript executor
	
	public static String captureScreenShot(WebDriver driver)
	{
		String screenshotPath = System.getProperty("user.dir")+"//Screenshots//"+getCurrentDate()+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot Captured");
		} catch (Exception e) {
			System.out.println("Unable to Capture Screenshot" +e.getMessage());
		}
		
		return screenshotPath;
		}
	
	public static String getCurrentDate()
	{
		DateFormat CustomFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date CurrentDate = new Date();
		
	 return CustomFormat.format(CurrentDate);
		
		
				
	}
	
	

}
