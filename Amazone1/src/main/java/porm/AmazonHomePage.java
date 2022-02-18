package porm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath="//a[@id='nav-logo-sprites']")
	private WebElement logo;
	@FindBy (xpath="//span[text()='Hello, Sign in']")
	private WebElement signIn;
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement email;
	@FindBy (xpath="//input[@id='continue']")
	private WebElement emailContinue;
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement signInSubmitButton;
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchfor;
	@FindBy (xpath="//input[@type='submit']")
	private WebElement search;
	@FindBy (xpath="(//a[@tabindex='0'])[3]")
	private WebElement signOut;
	@FindBy (xpath="//span[text()='Sign Out']")
	private WebElement logout;
	
	public AmazonHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,20);
	}
	
	public boolean checkLogoOfAmazon()
	{
		boolean result=logo.isDisplayed();
		return result;
	}
	public void clickOnSignIn()
	{
		signIn.click();
	}
	public void sendToEmail(String Email)
	{
		email.sendKeys(Email);
	}
	public void clickOnEmailContinue()
	{
		emailContinue.click();
	}
	public void sendToPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickOnSignInSubmitButton()
	{
		signInSubmitButton.click();
	}
	public void sendToSearchFor(String name)
	{
		searchfor.sendKeys(name);
	}
	public void clickOnSearch()
	{
		search.click();
	}
	public void logOutFromAmazon()
	{
		Actions act=new Actions(driver);
		act.moveToElement(signOut).moveToElement(logout)
		.click().build().perform();
	}
	
	
	
	
	
	
	
	
	
	
}
