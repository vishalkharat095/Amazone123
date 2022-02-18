package porm;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppleIphone12 {
	
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath="//input[@id='add-to-cart-button']")
	private WebElement iPhone12AddToCart;
	
	public AppleIphone12(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,20);
	}
	
	public void clickOnAddToCartButton()
	{
		ArrayList<String> add = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(0));
		driver.switchTo().window(add.get(1));
		iPhone12AddToCart.click();
		driver.switchTo().window(add.get(0));
	}


}
