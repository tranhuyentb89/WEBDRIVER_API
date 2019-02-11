package selenium;

import org.testng.annotations.Test;

//import junit.framework.Assert;

//import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_05_Default_Dropdown {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
  @Test
	public void TC_01_CheckTitle() throws Exception
	{
	  driver.get("https://daominhdam.github.io/basic-form/index.html");
	  WebElement element = driver.findElement(By.xpath("//select [@id='job1']"));
	  Select jobRole1 = new Select(element);
	  Assert.assertFalse(jobRole1.isMultiple());
	  System.out.println("Job Role 1 multiple is " + jobRole1.isMultiple());
	  //Select Automation Tester value and verify it
	  jobRole1.selectByVisibleText("Automation Tester");
	  Assert.assertEquals(jobRole1.getFirstSelectedOption().getText(), "Automation Tester");
	  Thread.sleep(3000);
	  //Select manual tester and verify it
	  jobRole1.selectByValue("manual");
	  Assert.assertEquals(jobRole1.getFirstSelectedOption().getText(), "Manual Tester");
	  Thread.sleep(3000);
	  //Select Mobile Tester and verify
	  jobRole1.selectByIndex(3);
	  Assert.assertEquals(jobRole1.getFirstSelectedOption().getText(), "Mobile Tester");
	  Thread.sleep(3000);
	  
	  Assert.assertEquals(jobRole1.getOptions().size(), 5);
	}
  @AfterClass
  public void afterClass() {
    driver.quit();
  }

} 
