package Login;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Base { 
	static WebDriver driver; 
  @Test
  public void TC1() throws Exception {
	  driver.get("https://www.easemytrip.com/");
	  driver.findElement(By.id("spnMyAcc")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[normalize-space()='Login or Signup']")).click();
	  driver.findElement(By.id("txtEmail")).sendKeys("srishtiprincess1999@gmail.com");
	  driver.findElement(By.id("shwotp")).click();
	  System.out.println("Enter OTP:");
	  Scanner sc=new Scanner(System.in);
	  int OTP = sc.nextInt();
	  driver.findElement(By.id("txtEmail1")).sendKeys(String.valueOf(OTP));
	  driver.findElement(By.id("OtpLgnBtn")).click();	  
  }
  
  @BeforeTest
 
	  public void beforeTest() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		  driver=new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
		  driver.manage().window().maximize();
		  
		  
	  }
  

  @AfterTest

	  public void afterTest() throws Exception {
		 // Thread.sleep(2000);
		//  driver.quit();
	  
  }

}
