package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {
	WebDriver driver;
	
	
	public ContactPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		
	}
	public ContactPage()
	{
		System.out.println("Default Constructor");
	}
	
	@FindBy(name ="email" ) WebElement username;
	@FindBy(name ="password" ) WebElement passwword;
	@FindBy(xpath ="//div[@class='ui fluid large blue submit button']" ) WebElement LoginBTN;
	
	public void LoginToApp(String user,String pass)
	{
		username.sendKeys(user);
		passwword.sendKeys(pass);
		LoginBTN.click();
		
		
	}
	

}
