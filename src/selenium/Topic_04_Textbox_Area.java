package selenium;

import org.testng.annotations.Test;

//import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_04_Textbox_Area {
	WebDriver driver;
	String customerName, gender, DateOfBirth, address, city, state, pinno, phoneNumber, email, password, CustomerID, editAddress, editCity,
	editState, editPin, editPhonenumber, editEmail;
	By nameLocator = By.xpath("//input[@name='name']");
	//By gender = By.xpath("//input[@name='rad1']");
	By dobLocator = By.xpath("//input[@id='dob']");
	By addressLocator = By.xpath("//textarea[@name='addr']");
	By cityLocator = By.xpath("//input[@name='city']");
	By stateLocator = By.xpath("//input[@name='state']");
	By pinnoLocator = By.xpath("//input[@name='pinno']");
	By phoneLocator = By.xpath("//input[@name='telephoneno']");
	By emailLocator = By.xpath("//input[@name='emailid']");
	

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		customerName ="Selenium";
		DateOfBirth ="2010-10-10";
		address ="124 Tam Trinh";
		city ="Ha NOi";
		state ="Viet Nam";
		pinno ="123456";
		phoneNumber ="098373727171";
		email ="tranhuyen" + random() +"@gmail.com";
		//password ="1234455";
		editAddress = "12456 Tam Trinh";
		editCity ="Edit Ha NOi";
		editState ="Edit Viet Nam";
		editPin ="123456";
		editPhonenumber ="098373727171";
		editEmail ="tranhuyentb" + random() +"@gmail.com";

		
	}
    @Test
    public void TC_03_Homepage_logo_Displayed() throws Exception  {
    	//Open the page
    	driver.get("http://demo.guru99.com/v4");
    	
    	//Login
    	driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr172599 ");
    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bYbYbun");
    	driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
    	
    	//Verify home-page success or not
    	String homepage = driver.findElement(By.xpath("//marquee[@class='heading3']")).getText();
    	Assert.assertEquals(homepage, "Welcome To Manager's Page of Guru99 Bank");
    	
    	//Click New Customer
    	driver.findElement(By.xpath("//a[text()='New Customer']")).click();
    	driver.findElement(nameLocator).sendKeys(customerName);
    	driver.findElement(dobLocator).sendKeys(DateOfBirth);
    	driver.findElement(addressLocator).sendKeys(address);
    	driver.findElement(cityLocator).sendKeys(city);
    	driver.findElement(stateLocator).sendKeys(state);
    	driver.findElement(pinnoLocator).sendKeys(pinno);
    	driver.findElement(phoneLocator).sendKeys(phoneNumber);
    	driver.findElement(emailLocator).sendKeys(email);
    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
    	driver.findElement(By.xpath("//input[@name='sub']")).click();
    	
    	//get ra CustomerID
    	CustomerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
    	System.out.println("Customer ID" + CustomerID);
    	
    	//verify tat ca cac thong tin duoc tao moi
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerName);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), DateOfBirth);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pinno);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phoneNumber);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), email);
    	
    	Thread.sleep(3000);
	
	
 }
    @Test
    public void TC_04_UpdateCustomer() throws Exception {
    	driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
    	driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
    	driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
    	
    	//Step 08 - Verify giá trị tại 2 field: Customer Name và Address đúng với dữ liệu khi tạo mới New Customer tại Step 04
    	Assert.assertEquals(driver.findElement(nameLocator).getAttribute("value"), customerName);
    	Assert.assertEquals(driver.findElement(addressLocator).getText(), address);
    	
    	//Step 09. Nhap gia tri moi tai tat ca cac field enable
    	driver.findElement(addressLocator).clear();
    	driver.findElement(addressLocator).sendKeys(editAddress);
    	driver.findElement(cityLocator).clear();
    	driver.findElement(cityLocator).sendKeys(editCity);
    	driver.findElement(stateLocator).clear();
    	driver.findElement(stateLocator).sendKeys(editState);
    	driver.findElement(pinnoLocator).clear();
    	driver.findElement(pinnoLocator).sendKeys(editPin);
    	driver.findElement(phoneLocator).clear();
    	driver.findElement(phoneLocator).sendKeys(editPhonenumber);
    	driver.findElement(emailLocator).clear();
    	driver.findElement(emailLocator).sendKeys(editEmail);
    	driver.findElement(By.xpath("//input[@name='sub']")).click();
    	
    	//Step 10 Verify du lieu sau khi update thanh cong
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), editAddress);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), editCity);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), editState);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), editPin);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), editPhonenumber);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editEmail);
    	
    	Thread.sleep(3000);
    }
    public int random() {
    	Random random = new Random();
    	return random.nextInt(999999);
    	
    }
    @AfterClass
    public void afterClass() {
    	driver.quit();
  }

}
