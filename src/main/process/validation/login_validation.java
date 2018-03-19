package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login_validation {
	
	
	
	
	 By username=By.xpath("//*[@id='login_form']/div[1]/input");
	 By password=By.xpath("//*[@id='login_form']/div[2]/input");
	 By loginbutton=By.xpath("//*[@id='loginBtn']");
	 By signout=By.partialLinkText("Sign Out"); 
	 
	 By errortextmsg=By.xpath("//p[@class='msg-panel error']");
	 By headerprofimg=By.xpath("*//img[@class='fullcircle']");	 
	 String blankusernamealerttext="Sorry! Email address/Username should not be blank."; 
	 String blankpwdalerttext="Sorry! Password should not be blank."; 
	 String invalidlogincredentialalert="Sorry! You have entered incorrect Email/Password";
	 
	 public WebDriver driver;	
	 
	 
	 public login_validation(WebDriver driver)
	 {
		 
		 this.driver=driver;
	 }
	 
	  public void  blank_username_validation() throws Exception {
			
			 fillup("","abcd1234@");
			 driver.findElement(loginbutton).click();
			String originalalerttext=driver.findElement(errortextmsg).getText();
			Assert.assertEquals(blankusernamealerttext, originalalerttext);
			
		  }
	  
	  
	  public void blank_password_validation() throws Exception {
			
			 fillup("test","");
			 driver.findElement(loginbutton).click();
			String originalalerttext=driver.findElement(errortextmsg).getText();
			Assert.assertEquals(blankpwdalerttext, originalalerttext);
		  }
	  
	  
	  public void invalid_login_credential_validation() throws Exception {
			
			 fillup("swarnendu","abcd1234");
			 driver.findElement(loginbutton).click();
			String originalalerttext=driver.findElement(errortextmsg).getText();
			Assert.assertEquals(invalidlogincredentialalert, originalalerttext);
		  }
		 
	  public void valid_login() throws Exception {
		
		 fillup("swarnendu","abcd1234@");
		 driver.findElement(loginbutton).click();
	  }
	  
	  
	  public void logout() throws InterruptedException{
			  
		  driver.findElement(headerprofimg).click();
		  driver.findElement(signout).click();
	  }
	  
	  public void fillup(String uname ,String pwd) throws Exception {
		  driver.findElement(username).clear();
		  driver.findElement(username).sendKeys(uname);
		  driver.findElement(password).clear();
		  driver.findElement(password).sendKeys(pwd); 	  
	  }
	  
}
