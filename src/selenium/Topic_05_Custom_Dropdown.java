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
	JavascriptExecutor javascript;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		javascript = (JavascriptExecutor)driver;
		//driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
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
  @Test
  public void TC_04_mikerodham() throws Exception {
	  driver.get("https://mikerodham.github.io/vue-dropdowns/");
	  selectCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//li", "Second Option");
	  
	  Thread.sleep(3000);
	  selectCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//li", "First Option");
	  Thread.sleep(3000);
	  selectCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//li", "Third Option");

	  Thread.sleep(3000);
  }
  @Test
  public void TC_05_JqueryEditable() throws Exception {
	  driver.get("http://indrimuska.github.io/jquery-editable-select/");
	  editAble("//div[@id='default-place']/input", "//div[@id='default-place']//li[contains(@class,'es-visible')]", "Land Rover");
	  
	  Thread.sleep(3000);
  }
@Test
  public void TC_MultipleSelect() throws Exception
  {
  	driver.get("http://multiple-select.wenzhixin.net.cn/examples/#basic.html");
  	WebElement element = driver.findElement(By.xpath("//div[@class='content']/iframe"));
  	driver.switchTo().frame(element);
  	driver.findElement(By.xpath("//button[@class='ms-choice']")).click();
  	driver.findElement(By.xpath("//span[text()='June']/preceding-sibling::input")).click();
  	
  	
  	WebElement November = driver.findElement(By.xpath("//span[text()='November']/preceding-sibling::input"));
  	javascript.executeScript("arguments[0].scrollIntoView(true);", November);
  	driver.findElement(By.xpath("//span[text()='November']/preceding-sibling::input")).click();
  	
  	
  	WebElement January = driver.findElement(By.xpath("//span[text()='January']/preceding-sibling::input"));
  	javascript.executeScript("arguments[0].scrollIntoView(true);", January);
  	driver.findElement(By.xpath("//span[text()='January']/preceding-sibling::input")).click();

  	
  	WebElement August = driver.findElement(By.xpath("//span[text()='August']/preceding-sibling::input"));
  	javascript.executeScript("arguments[0].scrollIntoView(true);", August);
  	driver.findElement(By.xpath("//span[text()='August']/preceding-sibling::input")).click();
  	
  	Assert.assertTrue(driver.findElement(By.xpath("//span[text()='4 of 12 selected']")).isDisplayed());

  	Thread.sleep(3000);
  }
@Test
public void TC_MultipleSelect02() throws Exception {
	driver.get("https://semantic-ui.com/modules/dropdown.html");
	driver.findElement(By.xpath("//div[@class='ui fluid dropdown selection multiple']")).click();
	driver.findElement(By.xpath("//div[@class='menu transition visible']//div[text()='Angular']")).click();;
	
  	WebElement HTML = driver.findElement(By.xpath("//div[@class='menu transition visible']//div[text()='HTML']"));
  	javascript.executeScript("arguments[0].scrollIntoView(true);", HTML);
  	HTML.click();
  	Thread.sleep(3000);
	
	
	
}
  public void selectCustomDropdown(String parentXpath, String childXpath, String valueExpected) {
	  //click de mo dropdownlist
	  WebElement parent = driver.findElement(By.xpath(parentXpath));
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
  public void editAble(String parentxPath, String childXpath, String valueExpected)
  {
	  //click vao dropdownlist
	  WebElement parent = driver.findElement(By.xpath(parentxPath));
	  javascript.executeScript("arguments[0].click()", parent);
	  
	  // Go 1 chu bat ky de tim kiem
	  parent.sendKeys("A");
	  
	  // Wait cho den khi tat ca cac item con duoc hien thi
	  List<WebElement> child = driver.findElements(By.xpath(childXpath));
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfAllElements(child));
	  
	  for(WebElement childItem: child)
	  {
		  if(childItem.getText().equals(valueExpected))
		  {
			  javascript.executeScript("arguments[0].scrollIntoView(true);", childItem);
			  childItem.click();
			  break;

		  }
	  }
	  
	  
  }
  
  @AfterClass
  public void afterClass() {
    driver.quit();
  }

} 

