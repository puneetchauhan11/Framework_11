package com.crm.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.utility.BrowserFactory;
import com.crm.utility.ConfigDataProvider;
import com.crm.utility.ExcelDataProvider;
import com.crm.utility.Helper;



public class Base {
	
	public WebDriver driver;
	 public ExcelDataProvider excel;
	 public ConfigDataProvider config;
	 public ExtentReports report;
	 public ExtentTest logger;
	
	 @BeforeSuite
	public void SetUpData()
	{
	    excel= new ExcelDataProvider();
	    config = new ConfigDataProvider();
	    ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCrm"+Helper.getCurrentDate()+".html"));
	    report = new ExtentReports();
	    report.attachReporter(extent); 
	   
	    
	}
    @Parameters("browser")
	@BeforeClass
	public void setUp(String browser)
	{
		driver = BrowserFactory.startApplication(driver, browser, config.getStageURl());
	}
	
    @AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBroswer(driver);
	}
    @AfterMethod
	public void tearDownMethod(ITestResult result)
	{
        if(result.getStatus()==ITestResult.FAILURE)		
        {
        	try {
				logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
        }
        else if(result.getStatus()==ITestResult.SUCCESS)		
        {
        	try {
				logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
        }
        report.flush(); 
	}
}
