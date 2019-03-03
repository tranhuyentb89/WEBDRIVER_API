package selenium;

import org.testng.annotations.Test;

//import junit.framework.Assert;

//import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_06_HandleButtonRadioCheckboxAlert {
	WebDriver driver;
	JavascriptExecutor javascript;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		javascript =(JavascriptExecutor)driver;
		//driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
  @Test
	public void TC_01_HandleButton() throws Exception
	{
	  driver.get("http://live.guru99.com/");
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/login/");
	  //JavascriptExecutor javascript = (JavascriptExecutor)driver;
	  javascript.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Create an Account']")));
	  Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/create/");

	  Thread.sleep(3000);
	  
	}
//  @Test
//	public void TC_02_Checkbox() throws Exception
//	{
//	  driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
//	  
//	  WebElement dualZoneCheckbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
//	  javascript.executeScript("arguments[0].click();", dualZoneCheckbox);
//	  Thread.sleep(3000);
//	  
//	  Assert.assertTrue(dualZoneCheckbox.isSelected());
//	  
//	  if(dualZoneCheckbox.isSelected())
//	  {
//		  javascript.executeScript("arguments[0].click();", dualZoneCheckbox);
//	  }
//	  Assert.assertFalse(dualZoneCheckbox.isSelected());
//	  
//	}
//  @Test
//  public void TC_03_RadioButton() throws Exception {
//	  driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
//	  WebElement carEngineRadio = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input"));
//	  javascript.executeScript("arguments[0].click();", carEngineRadio);
//	  Thread.sleep(3000);
//	  Assert.assertTrue(carEngineRadio.isSelected());
//	  if(!carEngineRadio.isSelected()) {
//		  javascript.executeScript("arguments[0].click();", carEngineRadio);
//	  }
//	  Assert.assertTrue(carEngineRadio.isSelected());
//	  Thread.sleep(3000);
//  }
//  @Test
//  public void TC_04_alert() throws Exception
//  {
//	  driver.get("https://daominhdam.github.io/basic-form/index.html");
//	  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//	  Alert alert=driver.switchTo().alert();
//
//	  String jsAlertMsg = alert.getText();
//	  Assert.assertEquals(jsAlertMsg, "I am a JS Alert");
//	  Thread.sleep(3000);
//	  alert.accept();
//	  Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result' and text()='You clicked an alert successfully ']")).isDisplayed());
//	  Thread.sleep(3000);
//  }
//  @Test
//  public void TC_05() throws Exception {
//	  driver.get("https://daominhdam.github.io/basic-form/index.html");
//	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//	  
//	  Alert alert = driver.switchTo().alert();
//	  
//	  String jsMsg = alert.getText();
//	  Assert.assertEquals(jsMsg, "I am a JS Confirm");
//	  Thread.sleep(3000);
//	  alert.accept();
//	  
//	  Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Ok");
//	  Thread.sleep(3000);
//  }
	@Test
  public void TC_06() throws Exception {
	  driver.get("https://daominhdam.github.io/basic-form/index.html");
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	  
	  Alert alert = driver.switchTo().alert();
	  
	  String jsMsg = alert.getText();
	  Assert.assertEquals(jsMsg, "I am a JS prompt");
	  //Thread.sleep(3000);
	  alert.sendKeys("Automation Test 08");
	  Thread.sleep(3000);
	  alert.accept();
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: Automation Test 08");
	  Thread.sleep(3000);
  }
	@Test
	  public void TC_07() throws Exception {
		  driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		  Thread.sleep(3000);
		  
	  }



  @AfterClass
  public void afterClass() {
    driver.quit();
  }

  }

