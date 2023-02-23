package excelrprojects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PimPage {
	public static Properties prop3;
	public static WebDriver driver;
	
@org.testng.annotations.BeforeMethod
	public void BeforeMethod() throws IOException {

		String Data3 = ".\\src\\main\\java\\com\\HybridFrame\\DataPimpage.properties";
		FileInputStream file1 = new FileInputStream(Data3);
		prop3 = new Properties();
		prop3.load(file1);
		

     WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		  driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       driver.get(prop3.getProperty("url"));
	
	
}

@Test(priority = 1)
public void ValidatePimWithValidName() {
	driver.findElement(By.name("username")).sendKeys(prop3.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop3.getProperty("Pwd"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimbutton"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimadduser"))).click();
	driver.findElement(By.name("firstName")).sendKeys("Fiona");
	driver.findElement(By.name("lastName")).sendKeys("Grace");
	driver.findElement(By.xpath(prop3.getProperty("Employeeid"))).sendKeys("105");
	driver.findElement(By.xpath(prop3.getProperty("savebutton"))).click();
	String actual = prop3.getProperty("actual");
	String expected = prop3.getProperty("Expect");
	Assert.assertNotEquals(actual, expected);
	driver.quit();
	
}
@Test(priority = 2)
public void ValidatePimWithInvalidName() {
	
	driver.findElement(By.name("username")).sendKeys(prop3.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop3.getProperty("Pwd"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimbutton"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimadduser"))).click();
	driver.findElement(By.name("firstName")).sendKeys("Shi");
	driver.findElement(By.name("lastName")).sendKeys("12325");
	driver.findElement(By.xpath(prop3.getProperty("Employeeid"))).sendKeys("105");
	driver.findElement(By.xpath(prop3.getProperty("savebutton"))).click();
	String actual = prop3.getProperty("actual");
	String expected = prop3.getProperty("Expect");
	Assert.assertNotEquals(actual, expected);
	driver.quit();
	
}
@Test(priority = 3)
public void ValidatePimwithoutfirstname() {
	driver.findElement(By.name("username")).sendKeys(prop3.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop3.getProperty("Pwd"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimbutton"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimadduser"))).click();
	driver.findElement(By.name("firstName")).sendKeys("");
	driver.findElement(By.name("lastName")).sendKeys("12325");
	driver.findElement(By.xpath(prop3.getProperty("Employeeid"))).sendKeys("105");
	driver.findElement(By.xpath(prop3.getProperty("savebutton"))).click();
String actual = driver.getCurrentUrl();
String expected = prop3.getProperty("Expect");
Assert.assertEquals(actual, expected);
	 driver.quit();
}
@Test(priority = 4)
public void ValidatePimwithoutlastname() {
	driver.findElement(By.name("username")).sendKeys(prop3.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop3.getProperty("Pwd"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimbutton"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimadduser"))).click();
	driver.findElement(By.name("firstName")).sendKeys("");
	driver.findElement(By.name("lastName")).sendKeys("");
	driver.findElement(By.xpath(prop3.getProperty("Employeeid"))).sendKeys("105");
	driver.findElement(By.xpath(prop3.getProperty("savebutton"))).click();
String actual = driver.getCurrentUrl();
String expected = prop3.getProperty("Expect");
Assert.assertNotEquals(actual, expected);
	 driver.quit();
}

@AfterMethod
public void Aftermethod() {
	driver.quit();
}}
