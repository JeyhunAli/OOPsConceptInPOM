//here im creating BasePage class then extending MainPage class 
//once i extended gives error to add constructor after that another error add the all the unimplemented method from 
//mainPage class where all the abstract methods are available 

package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends MainPage{

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {  //this is the method override from parent class that i achieved in my project 
		return driver.getTitle();    //method ovveriden 
	}

	
	 //here im calling getElement method (right below method)
	@Override
	public  String getPageHeader(By locator) {
		return getElement(locator).getText();              
	}

	//how we are creating web element in selenium for that driver.findelment by . locator 
	//here im gonna cover exception handling as well im not gonna use throws method 
	//im gonna use proper exception handling with try catch block with the message 
	//this is the wrapper function here 
	//lets say if i cannot create the locator properly it will return null
	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
				}
		catch(Exception e) {  //why Exception e  because its parent all the exceptions whatever exception it comes it will catch
			//if no such element is coming it will print this message
			System.out.println("some error occured while creating element "+ locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	//here wait coming from page class so no need to declare or create webdriver wait again and again 
	@Override
	public void waitForElementPresent(By Locator) {
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locator));
			
			}
		catch(Exception e){
			System.out.println("some excepted/error occured while waiting for the element " + Locator.toString());
			}
		
		}

	@Override
	public void waitForPageTitle(String title) {
		//waiting explicitly its connected with main page
		try {
			wait.until(ExpectedConditions.titleContains(title));
			}
		catch(Exception e) {
			System.out.println("some excepted/error pccured while waiting for the element " + title); 
		}
	}
	
	

}

