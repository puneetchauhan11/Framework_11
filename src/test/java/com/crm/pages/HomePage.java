package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	Actions act ;
	
	
	public HomePage(WebDriver ldriver)
	{
		this.driver = ldriver;
		
	}
	public HomePage()
	{
		System.out.println("Default Constructor");
	}
	

	@FindBy(xpath ="//*[@id=\"main-nav\"]" ) WebElement NavigationBar;
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[3]/a") WebElement ContactIcon;
	
	public void clickonNavigationbar()
	{
		// test comment
	   act = new Actions(driver);
	   act.moveToElement(NavigationBar).perform();
	   
	   ContactIcon.click();
		
	}
	
	public void ClickOnContactMenu()
	{
	
	   
	   ContactIcon.click();
		
	}
	
	

}
