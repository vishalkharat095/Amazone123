package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFromStore {
	private WebDriverWait wait;
	private WebDriver driver;
	@FindBy (xpath="//input[@placeholder='Search store']")
	private WebElement searchTextbox;
	
	@FindBy (xpath="//button[text()='Search']")
	private WebElement searchFor;
	
	@FindBy (xpath="(//div[@class='title'])[2]")
	private WebElement manufactural;
	
	@FindBy (xpath="//a[text()='Apple']")
	private WebElement apple;
	
	@FindBy (xpath="//input[@id='attribute-option-6']")
	private WebElement cpu;
	
	@FindBy (xpath="//input[@id='attribute-option-8']")
	private WebElement memory;
	
	@FindBy (xpath="//button[text()='Add to cart']")
	private WebElement addToCart;
	
	public SearchFromStore(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	    wait=new WebDriverWait(driver,20);
	}
	
	
	public void sendToSearchTextbox(String thing)
	{
		searchTextbox.sendKeys(thing);
	}
	public void clickOnSearchFor()
	{
		searchFor.click();
	}
	public void clickOnManufactural()
	{
		manufactural.click();
	}
	public void selectManufacturalApple()
	{
		apple.click();
	}
	public void clickOnCeckboxCpu()
	{
		cpu.click();
	}
	public void clickOnCheckboxcMemory()
	{
		memory.click();
	}
	public void clickOnAddToCartButton()
	{
		wait.until(ExpectedConditions.visibilityOf(addToCart));
		addToCart.click();
	}
	public void addLaptopInCart() 
	{
		searchTextbox.sendKeys("laptop");
		searchFor.click();
		manufactural.click();
		apple.click();
		cpu.click();
		memory.click();
		
	//	wait.until(ExpectedConditions.visibilityOf(addToCart));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
	}
	
	

}
