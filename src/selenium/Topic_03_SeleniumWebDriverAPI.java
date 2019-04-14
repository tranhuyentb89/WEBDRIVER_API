package selenium;

import org.testng.annotations.Test;

//import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_03_SeleniumWebDriverAPI {
	WebDriver driver;
	By email = By.xpath("//input[@id='mail']");
	By ageUnder18 = By.xpath("//input [@id='under_18']");
	By education = By.xpath("//textarea [@id='edu']");
	By job1 = By.xpath("//select [@id='job1']");
	By interestDev = By.xpath("//input [@id='development']");
	By slider01 = By.xpath("//input [@id='slider-1']");
	By btnEnable = By.xpath("//button [@id='button-enabled']");
	//disable element
	By password = By.xpath("//textarea[@id='bio']");
	By radioDisable = By.xpath("//input [@id='password']");
	By bio = By.xpath("//textarea [@id='bio']");
	By jobRole2 = By.xpath("//select [@id='job2']");
	By checkboxDisable = By.xpath("//input [@id='check-disbaled']");
	By slider02 = By.xpath("//input [@id='slider-2']");
	By btnDisable = By.xpath("//button [@id='button-disabled']");
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void TC_01_checkIsDisplayed() throws Exception
	{
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		if(isDisplayed(email)) {
			driver.findElement(email).sendKeys("Automation Testing");
		}
		if(isDisplayed(ageUnder18)) {
			driver.findElement(ageUnder18).click();
		}
		if(isDisplayed(education)) {
			driver.findElement(education).sendKeys("Automation Testing");
		}
		Thread.sleep(3000);
	}
	@Test
	public void TC_02_checkEnableDisable()
	{
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		Assert.assertTrue(isElementEnable(email));
		Assert.assertTrue(isElementEnable(ageUnder18));
		Assert.assertTrue(isElementEnable(education));
		Assert.assertTrue(isElementEnable(job1));
		Assert.assertTrue(isElementEnable(interestDev));
		Assert.assertTrue(isElementEnable(slider01));
		Assert.assertTrue(isElementEnable(btnEnable));
		
		Assert.assertFalse(isElementEnable(password));
		Assert.assertFalse(isElementEnable(radioDisable));
		Assert.assertFalse(isElementEnable(bio));
		Assert.assertFalse(isElementEnable(jobRole2));
		Assert.assertFalse(isElementEnable(checkboxDisable));
		Assert.assertFalse(isElementEnable(slider02));
		Assert.assertFalse(isElementEnable(btnDisable));

	}
	@Test
	public void TC_03_checkSelected()
	{
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		driver.findElement(ageUnder18).click();
		Assert.assertTrue(isElementSelected(ageUnder18));
		driver.findElement(interestDev).click();
		Assert.assertTrue(isElementSelected(interestDev));
				
	}
	public boolean isDisplayed(By by) {
		WebElement element = driver.findElement(by);
		if(element.isDisplayed()) {
			return true;
		}return false;
	}
	public boolean isElementEnable(By by) {
		WebElement element = driver.findElement(by);
		if(element.isEnabled()) {
			System.out.println("Element"+ by + "is enable");
			return true;
		}
		else {
			System.out.println("Element"+ by + "is disable" );
			return false;
		}
		
	}
	public boolean isElementSelected(By by) {
		WebElement element = driver.findElement(by);
		if(element.isSelected()) {
			System.out.println(by + "is selected");
			return true;
		}
		else {
			System.out.println(by + "is not selected");
			element.click();
			return false;
		}
	}
	@AfterClass
	public void afterClass() {
    driver.quit();
  }

}