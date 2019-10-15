package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	//here copying private method from login page 
	private By header = By.xpath("//i18n-string[@data-key='login.signupLink.text']");

	
	
	
	
//here adding constructor from base class 
	public HomePage(WebDriver driver) {
		super(driver);
	}
//here copying all these methods from login page 
		public WebElement  getHeader() {
			return getElement(header);
		}
		
		
		public String getLoginPageTitle() {
			return getPageTitle();
			
		}
		
		
		public String getHomePageHeader() {
			return getPageHeader(header);
		}
		


	}


