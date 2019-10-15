package com.MyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myPages.BasePage;
import com.myPages.MainPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	WebDriver driver;
	public MainPage Mpage;  //created main page variables 
	
	@BeforeMethod
	@Parameters(value = { "browser" })
	
	
	public void setUpTest(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		else if (browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		else {
			System.out.println("no browser is defined in xml file...");
		}
		driver.get("https://app.hubspot.com/login");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Mpage = new BasePage(driver);  //top casting concept
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
