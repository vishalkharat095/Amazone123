package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import porm.AmazonHomePage;
import porm.AppleIphone12;
import porm.AppleMobail;

public class TestClass1 {
	
	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://www.amazon.in/");
	//	 driver.manage().window().maximize();
		 
		 AmazonHomePage amazonHomePage=new AmazonHomePage(driver);
		 amazonHomePage.checkLogoOfAmazon();
		 boolean finalResult=amazonHomePage.checkLogoOfAmazon();
		 if(finalResult==true)
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
		 
		 amazonHomePage.clickOnSignIn();
		 amazonHomePage.sendToEmail("8007877390");
		 amazonHomePage.clickOnEmailContinue();
		 amazonHomePage.sendToPassword("Vishal@95");
		 amazonHomePage.clickOnSignInSubmitButton();
		 amazonHomePage.sendToSearchFor("apple mobail");
		 amazonHomePage.clickOnSearch();
		 
		 AppleMobail appleMobail=new AppleMobail(driver);
		 appleMobail.clickOnMobailModel();
		 
		 AppleIphone12 appleIphone12 =new AppleIphone12(driver);
		 appleIphone12.clickOnAddToCartButton();
		 
		 amazonHomePage.logOutFromAmazon();
		 
		 
		 
		 
		 
		 
		 
		
	}

}
