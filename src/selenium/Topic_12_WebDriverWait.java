package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic_12_WebDriverWait {
	WebDriver driver;
	WebDriverWait expliciwait;
	Date date;
  public void TC_01_ImplicitWait() {
	  //step 01 - truy cap trang web
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed());
  }
  
  public void TC_02_invisible()
  {
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed());
	  expliciwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='loading']")));
  }
  public void TC_03()
  {
	  /*Test Script 03: Sử dụng Explicit wait
	  Check cho Hello world text visible -> sau đó check Helloworld text được hiển thị
	  Implicit wait chỉ set 2s
	  Step 01 - Truy cập vào trang: 
	  http://the-internet.herokuapp.com/dynamic_loading/2
	  Step 02 - Click the Start button
	  Step 03 - Wait Hello World visible
	  Step 04 - Check result text is "Hello World!"*/
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  expliciwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
	  expliciwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("v")));
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed());
  }
  @Test
  public void TC_04()
  {
	  /*Test Script 04: Sử dụng Explicit wait
	  Check cho Helloworld invisible + có trong DOM -> hết bao nhiêu s?
	  Check cho Helloworld invisible + ko có trong DOM -> hết bao nhiêu s?
	  Check cho Loading invisible + có trong DOM -> hết bao nhiêu s?
	  Check cho Loading invisible + ko có trong DOM -> hết bao nhiêu s?
	  Step 01 - Truy cập vào trang: 
	  http://the-internet.herokuapp.com/dynamic_loading/2
	  Step 02 - Check Hello World text invisible -> hết bao nhiêu s?
	  Step 03 - Check Loading invisible -> hết bao nhiêu s?
	  Step 04 - Click the Start button
	  Step 05 - Check Loading invisible -> hết bao nhiêu s?*/
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  
	  System.out.println("Start check invisible of hello world");
	  System.out.println(date= new Date());
	  expliciwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")));
	  System.out.println("End check invisible of hello world");
	  System.out.println(date= new Date());
	  
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  
	  System.out.println("Start check invisible of loading");
	  System.out.println(date= new Date());
	  expliciwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
	  System.out.println("End check invisible of loading");
	  System.out.println(date= new Date());


  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  expliciwait = new WebDriverWait(driver, 30);
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();

  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
