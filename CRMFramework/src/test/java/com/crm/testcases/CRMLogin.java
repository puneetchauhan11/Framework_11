package com.crm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.pages.Base;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.Helper;


public class CRMLogin extends Base{
	

	@Test 
	public void Login()
	{
		
		logger = report.createTest("Login To CRM");
	
		LoginPage lp =PageFactory.initElements(driver,LoginPage.class);
		
		logger.info("Starting application");
		lp.LoginToApp(excel.getStringdata("Credentials", 1, 0),excel.getStringdata("Credentials", 1, 1));
		
		logger.pass("Login sucessfull to CRM");
		
		

		
	}
	@Test
	public void MContact() throws InterruptedException
	{
		
		logger = report.createTest("Go To Contact page");
	
		
		logger.info("Trying to Navigate to contact page");
		
		HomePage hp= PageFactory.initElements(driver,HomePage.class);
		hp.clickonNavigationbar();
		Thread.sleep(3000);
		hp.ClickOnContactMenu();
		logger.pass("Navigation is sucessdull!!");
		

		
	}

}
