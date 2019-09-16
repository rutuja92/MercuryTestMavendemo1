package com.model;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTestDemo 
{
	public WebDriver driver;
	
		
	
  @Test(priority=1,description="verify that valid user1 able to login into mercury tours application by using valid username and password")
  public void loginwithvalidds1()
  {
	  System.out.println("In loginwithvalidds method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("rutujasalway123");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Rutu@44");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  System.out.println("fight finder image is dispalyed:"+flag);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
		 
  }
  @Test(priority=2,description="verify that valid user2 able to login into mercury tours application by using valid username and password")
  public void loginwithvalidds2()
  {
	  System.out.println("In loginwithvalidds method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("rutujasalway1234");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Rutu@444");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  System.out.println("fight finder iamge is displayed:"+flag1);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @Test(priority=3,description="verify that invalid user not able to login into mercury tours application by using valid username and password ")
  public void loginwithinvalidds3()
  {
	  System.out.println("In loginwithinvalidds method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("rutujasalway123454");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Rutu@444467");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean flag3=driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
	  System.out.println("Signon images is displayed: "+flag3);
  }
  @BeforeMethod
  public void getAllcookies() 
  {
	  System.out.println("In getAllcookies method BeforeMethod");
	  Set<Cookie>cookies=driver.manage().getCookies();
			  for (Cookie cookie:cookies)
			  {
				  System.out.println(cookie.getName());
			  }
  }
  @AfterMethod
  public void captureScreenshot() throws IOException 
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src,new File("C:\\Users\\RUTUJA\\eclipse-workspace\\mercuryTestMavendemo1\\Scrrenshotfolder1\\"));
	  System.out.println("screenshot has captured sucessfully");
	  
  }



  
  @BeforeClass
  public void maximizeBrowser() 
  {
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void deleteAllcookies() 
  {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("In enterApplicationURL method under BeforeTest");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  		  }
  

  @AfterTest
  public void dbConnectionClosed() 
  {
	  System.out.println("dbconncetion method under AfterTest");
  }

  @BeforeSuite
  public void openBrowser() 
  {
	  System.out.println("In openBrowser method under BeforeSuite");
	  System.setProperty("webdriver.chrome.driver", "C:\\29062019\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  System.out.println("open browser has open succesfully");
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  driver.close();
	  System.out.println("browser has closed ");
	  
  }

}
