package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import settings.launchBrowser;
import validation.login_validation;

public class login_test extends launchBrowser {
	
	public WebDriver driver;
	public login_validation lv;
	@BeforeClass
	public void setdriver(){
		
		driver=getdriver();
	}
	
	
 @Test(priority=1)
  public void loginvalidationtest() throws Exception { 
	  lv=new login_validation(driver);
	  //Thread.sleep(2000);
	  lv.blank_password_validation();
	  Thread.sleep(2000);
	  lv.blank_username_validation();
	  Thread.sleep(2000);
	  lv.invalid_login_credential_validation();
  }
  
 @Test(priority=2)
  public void validlogin() throws Exception { 
	   lv=new login_validation(driver);
	   Thread.sleep(2000);
	    lv.valid_login();
	    Thread.sleep(3000);
	    lv.logout();
	   
  }

  
}