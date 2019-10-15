package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MainPage {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	//creating the constructor in abstract class its allowed in java 
	public MainPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver, 25);
		
		}
	//creating abstract method kind a one rule that every page can follow this rule 
	//abstarct method has to be with abstract keyword 
	//abstract getpage title will return string thats why return type is string 
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator );
	
	public abstract WebElement getElement(By locator); 
	
	public abstract void waitForElementPresent (By Locator);
	
	public abstract void waitForPageTitle (String title);
	
	
	//here at the run time whatver the page im passing  lets say im passing login page or home page  then im checking getdeclared 
	//constructor what ever ther constructor is there im passing web driver instance and creating that particular class 
	//instead of writing that particular page lets say login page = new login page im using here new instance this also doing same 
	// action same performance creating object concept    
	//new instance here also use to create object that particular page 
	//and this is the non abstarct method example i created in my project frame work 
	//its basically nonAbstarct method in abstract clsss
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);//getdeclared method is alredy existing method
		}
		catch(Exception e ) {
			e.printStackTrace();
			return null;    // it means it gonna come to try catch block if anything happining it gonna return null 
		}
		
		
		
	}
	
}	
