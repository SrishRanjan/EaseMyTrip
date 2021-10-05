package Login;
//WRONG OTP WHEN SETTING PASSWORD!!!!!!
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

public class TC6 { 
	static WebDriver driver; 
	Properties prop = new Properties();
  @Test ( enabled = false, priority = 6)
  public void TC6() throws Exception {
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.id(prop.getProperty("MyAccount"))).click();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector(prop.getProperty("LogInSignUp"))).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id(prop.getProperty("EnterEmail"))).sendKeys(prop.getProperty("Mail"));
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id(prop.getProperty("Continue"))).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath(prop.getProperty("ResetPassword"))).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("txtEmail5")).sendKeys(prop.getProperty("Mail"));
	  driver.findElement(By.xpath(prop.getProperty("ContinueAgain"))).click();
	  System.out.println("Enter OTP:");
	  Scanner sc1=new Scanner(System.in);
	  int OTP = sc1.nextInt();
	  Thread.sleep(2000);
	  driver.findElement(By.id("otpFp")).sendKeys(String.valueOf(OTP));
	  Thread.sleep(1000);
	  driver.findElement(By.id("pass")).sendKeys(prop.getProperty("password"));
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@value='Reset Password']")).click();
	  Thread.sleep(1000);
	  String k=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(k,"invalid OTP!!!!");
		Thread.sleep(3000);
	  
	   
	  
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
