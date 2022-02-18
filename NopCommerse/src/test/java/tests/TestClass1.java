package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.DemoStore;
import pom.Register;
import pom.SearchFromStore;

public class TestClass1 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.get("https://demo.nopcommerce.com/");
	//	driver.manage().window().maximize();
	    
	    DemoStore demoStore = new DemoStore(driver);
	    demoStore.clickOnRegisterButton();
	    
	    Register register = new Register(driver);
	   // register.completeTheRegister();
	    register.selectGenderMale();
	    register.sendFirstName("atul");
	    register.sendLastName("gholap");
	    register.selectDay();
	    register.selectMonth();
	    register.selectYear();
	    register.sendEmail("atulgholap@gmail.com");
	    register.sendCompanyName("infosys");
	    boolean result1=register.checkNewsletter();
	    if(result1==true)
	    {
	    	System.out.println("newsletter is allready selected");
	    }
	    else
	    {
	    	System.out.println("newsletter is not selected");
	    }
	    register.sendPassword("Atul@123");
	    register.sendConfirmPassword("Atul@123");
	    register.clickOnRegister();
	    register.clickOnContinueButton();
	    
	    
	    
	    
	    SearchFromStore searchFromStore = new SearchFromStore(driver);
	    searchFromStore.addLaptopInCart();
	    searchFromStore.sendToSearchTextbox("Laptop");
	    searchFromStore.clickOnSearchFor();
	    searchFromStore.clickOnManufactural();
	    searchFromStore.selectManufacturalApple();
	    searchFromStore.clickOnCeckboxCpu();
	    searchFromStore.clickOnCheckboxcMemory();
	    searchFromStore.clickOnAddToCartButton();
	    
	    demoStore.clickOnLogOut();
	    
	    
	}

}
