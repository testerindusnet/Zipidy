package settings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class launchBrowser {
	
	public WebDriver driver;	
	 
	 @Parameters({"browser"})	
     @BeforeClass
	  public void openBrowser(String browser) {
		  
		  if(browser.equalsIgnoreCase("firefox"))
		  {
		    System.out.println("launching Firefox browser"); 
		    String firefoxdriverPath = "E://server//geckodriver//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxdriverPath);
			driver = new FirefoxDriver();
			driver.get("https://dev.zipidy.co.uk/collab/public_html/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		  }	
		  
		  if(browser.equalsIgnoreCase("chrome"))
		  {
		    System.out.println("launching Chrome browser"); 
		    String chromedriverPath = "E://server//chromedriver//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromedriverPath);
			driver = new ChromeDriver();
			driver.get("https://dev.zipidy.co.uk/collab/public_html/");
			driver.manage().window().maximize();			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		  }	
	  }
	  	 
	  public WebDriver getdriver(){		  
		  
		    return driver;
	  }
	  
	  
	  @AfterClass
	  public void endtest(){
		  
		 driver.quit();
	  }
	
	
}
