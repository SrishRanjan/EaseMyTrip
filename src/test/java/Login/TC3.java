package Login;
//WRONG OTP
import org.testng.annotations.Test;

//REGISTERING WITH WRONG OTP
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

public class TC3 { 
	static WebDriver driver;
	Properties prop = new Properties();
  @Test(priority =3)
  public void TC3() throws Exception {
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.id(prop.getProperty("MyAccount"))).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("LoginOrSignUp"))).click();
	  driver.findElement(By.id(prop.getProperty("EnterEmail"))).sendKeys(prop.getProperty("signupMail2"));
	  driver.findElement(By.id(prop.getProperty("Continue"))).click();
	 System.out.println("Enter OTP:");
	 Scanner sc=new Scanner(System.in);
	 int OTP = sc.nextInt();
	 driver.findElement(By.id(prop.getProperty("EnterOTP"))).sendKeys(String.valueOf(OTP));
	 driver.findElement(By.id(prop.getProperty("CreateMyAccount"))).click();	
	 boolean error =   driver.findElement(By.id(prop.getProperty("CreateMyAccount"))).isDisplayed();
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
		//Thread.sleep(2000);
	//	driver.quit();
	  
  }

}
