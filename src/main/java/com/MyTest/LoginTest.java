package com.MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myPages.HomePage;
import com.myPages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyLoginPageTitle() {
		//here in order to test loginPage i have to call that particular page for that i have two choise to create object 
		//of that class or to call by getInsatance method name which i created in MainPage 
		
		
		//here by extending this class Mpage comes from BaseTest and at the Base test on the class level i defined 
		//MainPage variable
		String title = Mpage.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
		
	}

	@Test(priority=2)
	public void verifyLoginPageHeaderTest() {
		
		String header = Mpage.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Don't have an account?");
		
	}
	@Test(priority=3)
	public void doLoginTest() {
		//this method returning home page thats why im gonna store it in homepage then importing 
		HomePage homepage= Mpage.getInstance(LoginPage.class).doLogin("Ali-ceyhun@list.ru", "Asderfgty5758");
		String homeHeader = homepage.getHomePageHeader();
		System.out.println(homeHeader);
		Assert.assertEquals(homeHeader, "Sales Dashboard");
		
		
	}
	
	
	
	
}

