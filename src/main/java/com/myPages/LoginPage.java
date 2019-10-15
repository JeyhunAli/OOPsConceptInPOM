//every page classes will extend BasePage class
//here defining page locators by   "By key word "
package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Ali-c
 *
 */
public class LoginPage extends BasePage{
	
	//here defining page locators by "By" ketword 
	//trying to achieve here encapsulation by private keyword 
	//then getters to access private 
	
	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("loginBtn");
	private By header = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}	
		//public getters 
		//using concept of encapsualtion 
		//trying to access private variables by public methods 
			//so here pay attention 
		//how to get emailId  right now email id is returning by mechanism but i want email id can return webelement so i can
		//perform send keys or click method right to that what i do so 
		//when i generate getters method it gives me this kind option --->> public By getEmailId() return emailId 
//but here im deleting by key word wrting instead of that WebElement eventually i need webelement to perfrom some action
		// it means im inheriting this generated methods directly from basepage 
		//so how let me explain im calling the particular method from base page and basically returning for example getelement 
		//method with declared locator then when i called that method then i pass inside of the parantesis intead of locator 
	//im passing emailId locator variable name

	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	public WebElement    getHeader() {
		return getElement(header);
	}
	
	
	public String getLoginPageTitle() {
		return getPageTitle();
		
	}
	
	
	public String getLoginPageHeader() {
		return getPageHeader(header);
	}
	
	
	public HomePage doLogin(String username, String Password) {  //retuning HomePage
	getEmailId().sendKeys(username);
	getPassword().sendKeys(Password);
	getLoginButton().click();
	
	//after all these actions it should return next landing page 
	//for that we use getInstance method from mainpage
	return getInstance(HomePage.class);
	
	}	
	
	//and now im going to achieve method overloading some negative testing 
	//here i will do some negative testing with blank credentials 
	//same method name with different parameters im trying to achieve method overloading 
	//instead of using if else condition im using method overloading as well 

	public void  doLogin() {  //oveloaded method
	getEmailId().sendKeys("");
	getPassword().sendKeys("");
	getLoginButton().click();
	
	
	
	}
	
	public void doLogin(String userCredentials) {
		
		if(userCredentials.contains("username")) {
			getEmailId().sendKeys(userCredentials.split(":")[1].trim());
			
		}else if (userCredentials.contains("password")) {
			getEmailId().sendKeys(userCredentials.split(":")[1].trim());
			
	}
		getLoginButton().click();












}


}

