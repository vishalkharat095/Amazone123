package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoStore {
	private WebDriverWait wait;
	
	@FindBy (xpath="//a[text()='Register']")
	private WebElement register;
	
	@FindBy (xpath="//a[text()='Log out']")
	private WebElement logOut;
	
	public DemoStore(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	    wait=new WebDriverWait(driver,10);
	}
	
	public void clickOnRegisterButton()
	{
		register.click();
	}
	
	public void clickOnLogOut()
	{
		wait.until(ExpectedConditions.visibilityOf(logOut));
		logOut.click();
	}

}
