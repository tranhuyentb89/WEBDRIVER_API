package selenium;

import org.testng.annotations.Test;

//import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_11_UploadFile {
	WebDriver driver;
	JavascriptExecutor javascript;
	String rootPath = System.getProperty("user.dir");
	String fileName01 ="01.jpg";
	String fileName02 ="02.jpg";
	String fileName03 ="03.png";
	String filePath01 = rootPath + "\\uploadFile\\" + fileName01;
	String filePath02 = rootPath + "\\uploadFile\\" + fileName02;
	String filePath03 = rootPath + "\\uploadFile\\" + fileName03;

@BeforeClass
public void beforeClass() {
	//run script voi Chrome
//	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
//	  driver = new ChromeDriver();
		
	// run TC voi Firefox
		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
	  	javascript = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
//@Test
public void TC_01_SingleUpload() throws Exception {
	driver.get("http://blueimp.github.com/jQuery-File-Upload/");
	WebElement uploadFileButton = driver.findElement(By.xpath("//input[@type='file']"));
	uploadFileButton.sendKeys(filePath01);
	Thread.sleep(3000);
	WebElement element = driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']"));
	javascript.executeScript("arguments[0].click();", element);
	Thread.sleep(3000);
}

//@Test
public void TC_02_MultipleUpload() throws Exception
{
	driver.get("http://blueimp.github.com/jQuery-File-Upload/");
	WebElement uploadFileButton = driver.findElement(By.xpath("//input[@type='file']"));
	uploadFileButton.sendKeys(filePath01 + "\n" + filePath02 + "\n" + filePath03);
	Thread.sleep(3000);
	
	//Verify tat ca cac file da duoc upload thanh cong
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ fileName01 +"']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ fileName02 +"']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ fileName03 +"']")).isDisplayed());
	
	//Click to start button to Upload File
	List<WebElement> startBtn = driver.findElements(By.xpath("//table//button[@class='btn btn-primary start']"));
	for(WebElement startButton: startBtn)
	{
		javascript.executeScript("arguments[0].click();", startButton);
		Thread.sleep(1000);
	}
	//Verify file da click start button thanh cong
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@href and @title ='"+ fileName01 +"']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@href and @title ='"+ fileName02 +"']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@href and @title ='"+ fileName03 +"']")).isDisplayed());

	Thread.sleep(3000);
}

//@Test
public void TC_03_AutoIT() throws Exception
{
	driver.get("http://blueimp.github.com/jQuery-File-Upload/");
	//click to add file button -> open dialog
	if (driver.toString().toLowerCase().contains("chrome")) 
	{
	    driver.findElement(By.cssSelector(".fileinput-button")).click();
	} 
	else if (driver.toString().toLowerCase().contains("firefox")) 
	{
	    clickToElementByJS("//input[@type='file']");
	}
	else
	{
		driver.findElement(By.xpath("//span[contains(text(),'Add files...')]")).click();
	}
	Thread.sleep(3000);
	//execute 1 file exe
	if (driver.toString().toLowerCase().contains("chrome")) 
	{
		Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\chrome.exe", filePath01 });
	} 
	else if (driver.toString().toLowerCase().contains("firefox")) 
	{
		Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\firefox.exe", filePath01 });
	}
	else
	{
		Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\ie.exe", filePath01 });
	}
	Thread.sleep(5000);
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ fileName01 +"']")).isDisplayed());
	driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
	Thread.sleep(2000);
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@href and @title ='"+ fileName01 +"']")).isDisplayed());



}

@Test
public void TC_04_Robot() throws Exception
{
	driver.get("http://blueimp.github.com/jQuery-File-Upload/");


	//Specify the file location with extension
	StringSelection select = new StringSelection(filePath01);

	//Copy to clipboard
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
	if (driver.toString().toLowerCase().contains("chrome")) 
	{
	    driver.findElement(By.cssSelector(".fileinput-button")).click();
	} 
	else if (driver.toString().toLowerCase().contains("firefox")) 
	{
	    clickToElementByJS("//input[@type='file']");
	}
	else
	{
		driver.findElement(By.xpath("//span[contains(text(),'Add files...')]")).click();
	}
	Thread.sleep(3000);


	//Click
	//driver.findElement(By.className("fileinput-button")).click();

	Robot robot = new Robot();
	Thread.sleep(1000);

	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);

	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(1000);

	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ fileName01 +"']")).isDisplayed());
	driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
	Thread.sleep(2000);
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@href and @title ='"+ fileName01 +"']")).isDisplayed());


}
public Object clickToElementByJS(String xpathName) {
    WebElement element = driver.findElement(By.xpath(xpathName));
    return javascript.executeScript("arguments[0].click();", element);
}

@AfterClass
public void afterClass() {
  driver.quit();
}
}
