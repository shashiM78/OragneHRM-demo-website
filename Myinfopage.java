package excelrprojects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.hc.core5.pool.PoolReusePolicy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myinfopage {
	public static Properties prop;

	 public static WebDriver driver;
	 
	 
	
	 @BeforeMethod
		public void beforemethod() throws Exception {
		String Data = ".\\src\\main\\java\\com\\HybridFrame\\DataMyinfo.properties";
		FileInputStream file = new FileInputStream(Data);
		prop = new Properties();
		prop.load(file);
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       driver.get(prop.getProperty("url"));
	 }	 
	
	@Test

	public void ValidateMyinfo01() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
		driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
		 Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Myinfobutton"))).click();
	 WebElement  firstname = driver.findElement(By.name("firstName"));
		 firstname.sendKeys("Shiva");
		 WebElement  middlename = driver.findElement(By.name("middleName"));
		 middlename.sendKeys("Kumar");
		 WebElement  lastname = driver.findElement(By.name("lastName"));
		lastname.sendKeys("M");
		driver.findElement(By.xpath(prop.getProperty("EmplyId"))).sendKeys(prop.getProperty("empid"));
		driver.findElement(By.xpath(prop.getProperty("Lience"))).sendKeys(prop.getProperty("licno"));
		WebElement country = driver.findElement(By.xpath(prop.getProperty("count")));
		country.sendKeys("A");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);
		Actions actionArrow1 = new Actions(driver);
		actionArrow1.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);
		Actions action2 = new Actions(driver);
		action2.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		Actions action3= new Actions(driver);
		action3.moveToElement(country).click().perform();
		driver.findElement(By.xpath(prop.getProperty("savebutton"))).click();
		String actual3 = driver.getCurrentUrl();
		String expect= prop.getProperty("expt");
		Assert.assertEquals(actual3, expect);
		driver.quit();

}

@Test

public void ValidateMyinfo02() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
	 Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("Myinfobutton"))).click();
 WebElement  firstname = driver.findElement(By.name("firstName"));
	// firstname.clear(); 
	 firstname.sendKeys("Shiva");
	 WebElement  middlename = driver.findElement(By.name("middleName"));
	// middlename.clear();
	 middlename.sendKeys("Kumar");
	 WebElement  lastname = driver.findElement(By.name("lastName"));
	// lastname.clear();
	lastname.sendKeys("M");
	driver.findElement(By.xpath(prop.getProperty("EmplyId"))).sendKeys("E054");
	driver.findElement(By.xpath(prop.getProperty("Lience"))).sendKeys("D057");
	WebElement country = driver.findElement(By.xpath(prop.getProperty("count")));
	country.sendKeys("N");
	Thread.sleep(3000);
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ARROW_DOWN).build().perform();
	Thread.sleep(3000);
	Actions actionArrow1 = new Actions(driver);
	actionArrow1.sendKeys(Keys.ARROW_DOWN).build().perform();
	Thread.sleep(3000);
	Actions action2 = new Actions(driver);
	action2.sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(3000);
	Actions action3= new Actions(driver);
	action3.moveToElement(country).click().perform();
	driver.findElement(By.xpath(prop.getProperty("savebutton"))).click();
	String actual3 = driver.getCurrentUrl();
	String expect1=prop.getProperty("expt");
	Assert.assertNotEquals(actual3, expect1);
	driver.quit();
}
public void aftermethod() {
	driver.quit();
}}
