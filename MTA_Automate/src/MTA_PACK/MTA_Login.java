package MTA_PACK;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class MTA_Login {
	
	WebDriver driver;
	//Report:
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	
	@BeforeClass
	public void setup() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver.exe");
		  driver=new ChromeDriver();
			driver.get("https://demo.emeetify.com:5010/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			ExtentTest test =extent.createTest("launch Browser & Website");
	}
	//Verify Title:
	@Test(priority=1, groups="Title")
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "MTA Architects";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		ExtentTest test = extent.createTest("VerifyTitle of the page");
		
	}
	
	//Verify Logo
	@Test(priority=2,groups="MTA LOGO")
	public void verifyMTALogo() {
		boolean loginLogo = driver.findElement(By.xpath("//img[@class='logo']")).isDisplayed();
		Assert.assertTrue(loginLogo,"Login Logo not displayed");
		ExtentTest test = extent.createTest("Verify MTA Logo");
	}
	//Login with valid username & password:
	@Test(priority=3,groups="Login")
	public void Login() {
		//Enter user & password:
		WebElement enterusername = driver.findElement(By.xpath("//input[@type='text']"));
		enterusername.sendKeys("accounts@multitechcorp.in");
		WebElement enterpassword = driver.findElement(By.xpath("//input[@type='password']"));
		enterpassword.sendKeys("mta@1234");
		WebElement clickLoginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		clickLoginBtn.click(); 
		
		//Validate Login page:
		
	}
		
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@BeforeTest()
		public void StartReport() {
		//	ExtentReports extent = new ExtentReports();
		//	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
			extent.attachReporter(spark);  }

		@AfterTest()
		public void EndReport() {
			extent.flush();
		}

		}
		
	
	
	
		
	

