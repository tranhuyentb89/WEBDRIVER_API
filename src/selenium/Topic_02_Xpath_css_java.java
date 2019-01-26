package selenium;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_css_java {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		//System.setProperty("webdriver.chorme.driver", ".\\lib\\chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void TC_01_LoginWithEmailPasswordEmpty()
	{
		driver.get("http://live.guru99.com");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.name("send")).click();
		
		String emailErrMsg = driver.findElement(By.id("advice-required-entry-email")).getText();
		Assert.assertEquals(emailErrMsg, "This is a required field.");
		
		String passErrMsg = driver.findElement(By.id("advice-required-entry-pass")).getText();
		Assert.assertEquals(passErrMsg, "This is a required field.");
	}
	@Test
	public void TC_02_LoginWithEmailPasswordInvalid()
	{
		driver.get("http://live.guru99.com");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("123434234@12312.123123");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.name("send")).click();
		
		String emailErrMsg = driver.findElement(By.id("advice-validate-email-email")).getText();
		Assert.assertEquals(emailErrMsg, "Please enter a valid email address. For example johndoe@domain.com.");
		
		String passErrMsg = driver.findElement(By.id("advice-required-entry-pass")).getText();
		Assert.assertEquals(passErrMsg, "This is a required field.");
	}
	@Test
	public void TC_03_LoginWithPWLessthanSixChar()
	{
		driver.get("http://live.guru99.com");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.name("send")).click();
		
		String passErrMsg = driver.findElement(By.id("advice-validate-password-pass")).getText();
		Assert.assertEquals(passErrMsg, "Please enter 6 or more characters without leading or trailing spaces.");
	}
	@Test
	public void TC_04_LoginWithPasswordIncorrect()
	{
		driver.get("http://live.guru99.com");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123123123");
		driver.findElement(By.name("send")).click();
		
		String expectedErr = driver.findElement(By.xpath("//li[@class='error-msg']//span[text()='Invalid login or password.']")).getText();
		Assert.assertEquals(expectedErr, "Invalid login or password.");
		
	}
	@Test
	public void TC_05_CreateAnAccount()
	{
		driver.get("http://live.guru99.com");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//form[@id='login-form']//span[text()='Create an Account']")).click();
		
		driver.findElement(By.xpath("//div[@class='account-create']//input[@id='firstname']")).sendKeys("Huyen");
		driver.findElement(By.xpath("//div[@class='account-create']//*[@id='middlename']")).sendKeys("Thi");
		driver.findElement(By.xpath("//div[@class='account-create']//*[@id='lastname']")).sendKeys("Tran");
		driver.findElement(By.xpath("//div[@class='account-create']//*[@id='email_address']")).sendKeys("automation"+radomNumber()+"@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirmation")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='button']")).click();
		
		String expectedMsg = driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText();
		Assert.assertEquals(expectedMsg, "Thank you for registering with Main Website Store.");
		
	}
	public int radomNumber()
	{
		Random radom = new Random();
		return radom.nextInt(999999);
	}
	@AfterClass
	public void afterClass() {
    driver.quit();
  }

}
