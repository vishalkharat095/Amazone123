package porm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppleMobail {
	
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath="//span[text()='Apple iPhone 12 (128GB) - Black']")
	private WebElement mobailModel;
	
	public AppleMobail(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,20);
	}
	
	public void clickOnMobailModel()
	{
		mobailModel.click();
	}

}
