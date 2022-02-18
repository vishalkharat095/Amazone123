package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {
	
	@FindBy (xpath="//label[text()='Male']")
	private WebElement gender;
	
	@FindBy (xpath="//input[@name='FirstName']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@name='LastName']")
	private WebElement lastname;
	
	@FindBy (xpath="//select[@name='DateOfBirthDay']")
	private WebElement day;
	
	@FindBy (xpath="//select[@name='DateOfBirthMonth']")
	private WebElement month;
	
	@FindBy (xpath="//select[@name='DateOfBirthYear']")
	private WebElement year;
	
	@FindBy (xpath="//input[@id='Email']")
	private WebElement email;
	
	@FindBy (xpath="//input[@id='Company']")
	private WebElement company;
	
	@FindBy (xpath="//input[@value='true']")
	private WebElement newsLetter;
	
	@FindBy (xpath="//input[@name='Password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@name='ConfirmPassword']")
	private WebElement confirmPassword;
	
	@FindBy (xpath="//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy (xpath="//a[text()='Continue']")
	private WebElement continueButton;
	
	
	public Register(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectGenderMale()
	{
		gender.click();
	}
	public void sendFirstName(String Fname)
	{
		firstName.sendKeys(Fname);
	}
	public void sendLastName(String Lname)
	{
		lastname.sendKeys(Lname);
	}
	public void selectDay()
	{
		Select s=new Select(day);
		s.selectByVisibleText("21");
	}
	public void selectMonth()
	{
		Select j=new Select(month);
		j.selectByIndex(1);
	}
	public void selectYear()
	{
		Select k=new Select(year);
		k.selectByVisibleText("1995");
		
	}
	public void sendEmail(String Email)
	{
		email.sendKeys(Email);
	}
	public void sendCompanyName(String companyName)
	{
		company.sendKeys(companyName);
	}
	public boolean checkNewsletter()
	{
		boolean result=newsLetter.isSelected();
		return result;
	}
		
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void sendConfirmPassword(String pass1)
	{
		confirmPassword.sendKeys(pass1);
	}
	public void clickOnRegister()
	{
		registerButton.click();
	}
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	public void completeTheRegister()
	{
		gender.click();
		firstName.sendKeys("Somes");
		lastname.sendKeys("Rathod");
		Select s=new Select(day);
		s.selectByVisibleText("21");
		Select j=new Select(month);
		j.selectByIndex(1);
		Select k=new Select(year);
		k.selectByVisibleText("1995");
		email.sendKeys("somesrathod@gmail.com");
		company.sendKeys("Wipro");
		boolean result=newsLetter.isSelected();
		if(result==true)
		{
			System.out.println("allready selected");
		}
		else
		{
			newsLetter.click();
		}
		password.sendKeys("Rohit@123");
		confirmPassword.sendKeys("Rohit@123");
		registerButton.click();
		continueButton.click();
	}

	

}
