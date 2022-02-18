package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import porm.AmazonHomePage;
import utils.Utility;

public class TestNGTestClass extends Browser{
	private WebDriver driver;
	private AmazonHomePage amazonHomePage;
	private int testID;
	
	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String browser) {
		System.out.println(browser);
//		driver=launchTheChromeBrowser();
		if(browser.equalsIgnoreCase("chrome")){
		   driver=launchTheChromeBrowser();
		}
		if(browser.equalsIgnoreCase("firefox")) {
	      driver=launchThefirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMObjects() {
		 System.out.println("Before Class");
		 
		 amazonHomePage=new AmazonHomePage(driver);
		 
	}
	
	@BeforeMethod
	public void loginToApplication() throws EncryptedDocumentException, IOException {
		 System.out.println("before method");
		 driver.get("https://www.amazon.in/");
		 
		 amazonHomePage.clickOnSignIn();
		 String username=Utility.getDataFromExcelSheet("test", 1, 0);
		 amazonHomePage.sendToEmail(username);
		 amazonHomePage.clickOnEmailContinue();
		 String password=Utility.getDataFromExcelSheet("test", 1, 1);
		 amazonHomePage.sendToPassword(password);
		 amazonHomePage.clickOnSignInSubmitButton();
	}
	
	@Test
	public void checkURLOfSearchBox( ) {
		testID=101;
		System.out.println("test 1");
		 amazonHomePage.sendToSearchFor("apple mobail");
		 amazonHomePage.clickOnSearch();
		 String url=driver.getCurrentUrl();
		 String tital=driver.getTitle();
		 Assert.assertEquals(url, "https://www.amazon.in/s?k=apple+mobail&ref=nb_sb_");
		 Assert.assertNotEquals(tital,"mobail");
		
	}
	@Test
	public void checkLogoOfHomePage() {
		testID=102;
		System.out.println("test2");
		amazonHomePage.checkLogoOfAmazon();
		boolean finalResult=amazonHomePage.checkLogoOfAmazon();
		Assert.assertTrue(finalResult);
	}
	
	@AfterMethod
	public void logoutFromTheApplication(ITestResult result) throws IOException {
		System.out.println("after method");
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.getScreenshot(driver, testID);
		}
	    amazonHomePage.logOutFromAmazon();
		
	}
	
	@AfterClass
	public void clearrPOMObjects() {
		System.out.println("after class");
		amazonHomePage=null;
	}
	@AfterTest
	public void closeTheBrowser() {
		System.out.println("after Test");
		driver.quit();
		driver=null;
		System.gc();
	}
	

}
