package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Browser;
import porm.AmazonHomePage;
import porm.AppleIphone12;
import porm.AppleMobail;

public class TestNGClass2 extends Browser{
	
	WebDriver driver;
	AmazonHomePage amazonHomePage;
	@BeforeClass
	public void launchTheBrowser() {
		 System.out.println("Before Class");
		
//		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//	     driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void loginToApplication() {
		 System.out.println("before method");
		 driver.get("https://www.amazon.in/");
		 amazonHomePage=new AmazonHomePage(driver);
		 amazonHomePage.clickOnSignIn();
		 amazonHomePage.sendToEmail("8007877390");
		 amazonHomePage.clickOnEmailContinue();
		 amazonHomePage.sendToPassword("Vishal@95");
		 amazonHomePage.clickOnSignInSubmitButton();
	}
	@Test
	public void checkURLOfSearchBox( ) {
		System.out.println("test 1");
		 amazonHomePage.sendToSearchFor("apple mobail");
		 amazonHomePage.clickOnSearch();
		 AppleMobail appleMobail=new AppleMobail(driver);
		 appleMobail.clickOnMobailModel();
		 
		 AppleIphone12 appleIphone12 =new AppleIphone12(driver);
		 appleIphone12.clickOnAddToCartButton();
		
	}
	@AfterMethod
	public void logoutFromTheApplication() {
		System.out.println("after method");
		 amazonHomePage.logOutFromAmazon();
		
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
		driver.close();;
	}
	
	
	

}
