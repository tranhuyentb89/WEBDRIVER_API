package selenium;

import org.testng.annotations.Test;

//import junit.framework.Assert;

//import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_05_Custom_Dropdown {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
  @Test
	public void TC_01_JQuery() throws Exception
	{
	  driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
	  
	  selectCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//li[@class='ui-menu-item']/div", "19");
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='19']")).isDisplayed());
	  //Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='19']")).isDisplayed());
	  Thread.sleep(3000);
	  
	  selectCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//li[@class='ui-menu-item']/div", "10");
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='10']")).isDisplayed());
	  Thread.sleep(3000);

	  selectCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//li[@class='ui-menu-item']/div", "8");
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='8']")).isDisplayed());
	  Thread.sleep(3000);

	  selectCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//li[@class='ui-menu-item']/div", "6");
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='6']")).isDisplayed());
	  Thread.sleep(3000);

	}
  @Test
  public void TC_02_Angular() throws Exception {
	  driver.get("https://material.angular.io/components/select/examples");
	  selectCustomDropdown("//mat-select[@placeholder='State']", "//mat-option", "Alaska");
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Alaska']")).isDisplayed());
	  Thread.sleep(3000);

	  selectCustomDropdown("//mat-select[@placeholder='State']", "//mat-option", "Wyoming");
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Wyoming']")).isDisplayed());
	  Thread.sleep(3000);

	  selectCustomDropdown("//mat-select[@placeholder='State']", "//mat-option", "Washington");
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Washington']")).isDisplayed());
	  Thread.sleep(3000);

	  selectCustomDropdown("//mat-select[@placeholder='State']", "//mat-option", "Louisiana");
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Louisiana']")).isDisplayed());
	  Thread.sleep(3000);

	  selectCustomDropdown("//mat-select[@placeholder='State']", "//mat-option", "Alabama");
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Alabama']")).isDisplayed());
	  Thread.sleep(3000);

  }
  @Test
  public void TC_03_Telerik() throws Exception
  {
	  driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
	  selectCustomDropdown("//span[@aria-owns='color_listbox']//span[@class='k-dropdown-wrap k-state-default']", "//ul[@id='color_listbox']/li", "Grey");
	  Thread.sleep(3000);
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }
  public void selectCustomDropdown(String parentXpath, String childXpath, String valueExpected) {
	  //click de mo dropdownlist
	  WebElement parent = driver.findElement(By.xpath(parentXpath));
	  JavascriptExecutor javascript = (JavascriptExecutor)driver;
	  javascript.executeScript("arguments[0].click()", parent);
	  
	  //wait cho cac item duoc hien thi
	  List <WebElement> child = driver.findElements(By.xpath(childXpath));
      WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
	  waitExplicit.until(ExpectedConditions.visibilityOfAllElements(child));
	  
	  //get text tat ca cac item ra va kiem tra bang gia tri mong muon hay ko
	  for(WebElement childItem: child) {
		  if(childItem.getText().equals(valueExpected)) {
			  //scroll den item can chon
			  javascript.executeScript("arguments[0].scrollIntoView(true);", childItem);
			  
			  //click vao item nay
			  childItem.click();
			  break;
		  }
	  }	  
  }

} 

