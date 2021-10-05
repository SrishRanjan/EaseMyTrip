package Login;
//LOG IN WITH WRONG PASSWORD
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC8 { 
	static WebDriver driver;
	Properties prop = new Properties();
  @Test (enabled = true, priority = 8 )
  public void TC8() throws Exception {
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.id(prop.getProperty("MyAccount"))).click();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector(prop.getProperty("LogInSignUp"))).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id(prop.getProperty("EnterEmail"))).sendKeys(prop.getProperty("Mail"));
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id(prop.getProperty("Continue"))).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id(prop.getProperty("EnterPassword"))).sendKeys(prop.getProperty("wrongP"));
	  Thread.sleep(1000);
	 // driver.findElement(By.xpath("//input[@ng-click=\"Authenticate('P')\"]")).click();
	  driver.findElement(By.xpath(prop.getProperty("LogIn"))).click();
	  boolean error =   driver.findElement(By.xpath(prop.getProperty("LogIn"))).isDisplayed();
	  Assert.assertEquals(true, error);
	   
  }
  
  @BeforeTest
 
	  public void beforeTest() throws Exception {
	  prop.load(new FileInputStream("src/system.property"));
		  System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		  driver=new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
		  driver.manage().window().maximize();
		  
		  
	  }
  

  @AfterTest

	  public void afterTest() throws Exception {
		  Thread.sleep(2000);
		  driver.quit();
	  
  }

}

