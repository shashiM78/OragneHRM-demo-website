package excelrprojects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	public static Properties prop;

	 public static WebDriver driver;
	 
	 
	
	 @BeforeMethod
		public void beforemethod() throws Exception {
		String Data = ".\\src\\main\\java\\com\\HybridFrame\\Data.properties";
		FileInputStream file = new FileInputStream(Data);
		prop = new Properties();
		prop.load(file);
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       driver.get(prop.getProperty("url"));	
	 }
		
	
	    @ Test(priority = 1)
	    public void ValidateLoginWithValidData() throws InterruptedException   {
	    	driver.get(prop.getProperty("url"));
	    	Thread.sleep(2000);
       driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
    	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
   		driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
   	  String actual = 	driver.getCurrentUrl();
   	  String expected = prop.getProperty("expect");
   		Assert.assertEquals(actual, expected); 
   		driver.quit();
   		}
   		
   	
	    @Test(priority = 2)
	    public void ValidateLoginWithInvalidName() {
	    	driver.get(prop.getProperty("url"));
   	        driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname1"));
 	        driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
 	        driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
            String actualUrl=driver.getCurrentUrl();
             String expectedUrl =prop.getProperty("act");
            Assert.assertEquals(actualUrl,expectedUrl );
 	driver.quit();
	}
	    
	    @Test(priority = 3)
	    public void ValidateLoginWithoutInvalidPassword() {
	    driver.get(prop.getProperty("url"));
	    driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	 	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd1"));
	 	driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
	 	String actualurl1=driver.getCurrentUrl();
	 	String	expectedUrl1=prop.getProperty("expect");
	    Assert.assertEquals(actualurl1,expectedUrl1 );
	 driver.quit();
	    }
	    
	    @Test(priority = 4)
	    public void ValidateLoginInvalidData() {
	    	driver.get(prop.getProperty("url"));
		    driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname2"));
		 	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd2"));
		 	driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
		 	String actualurl=prop.getProperty("act");
		 	 String	expectedUrl2= driver.getCurrentUrl();
		 	Assert.assertEquals(actualurl,expectedUrl2 );
		 	driver.quit();
		    }
		      
	
	@Test(priority = 5)
	public void ForgotPasswordWithvalidData() {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]")).click();
		
	 	 String	Expt= prop.getProperty("Passwordreset");
	 	 String actual3= driver.getCurrentUrl();
	 	Assert.assertEquals(actual3, Expt);
	 	driver.quit();
	}
	@Test(priority = 6)
	public void ForgotpasswordWithouValidData() {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname3"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]")).click();
		String actualUrl="forgotpasword";
	   String	expectedUrl= driver.getCurrentUrl();
	 	Assert.assertEquals(actualUrl, expectedUrl);
	 driver.quit();
	 	
	}
	
@AfterMethod
	public void afterMethod() {

driver.quit();

}}


