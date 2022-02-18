package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver launchTheChromeBrowser() {
		
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  return driver;
	}
	public static WebDriver launchThefirefoxBrowser() {
		
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\Downloads\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 return driver;
	}
}
