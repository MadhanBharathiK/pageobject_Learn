package ReprotWithScreenShot;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class demoScreenMT {
	
	public WebDriver driver;
	public ExtentReports extent;   
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent() {
		
		//Initalize extent report:
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		extent.addSystemInfo("Host Name", "Madhan Device");
		
		extent.addSystemInfo("User Name", "Madhan");
		extent.addSystemInfo("Enivronment","QA");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
		}
	
	public static String getScreenShot(WebDriver driver,String screenshotName) throws IOException {
		
		String dateName = new SimpleDateFormat("yyyyMMddhmmss").format(new Date(0));
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//After executiom, you could see a folder "FailedTestsScreenshots";
		//under src folder
		
		String destination = System.getProperty("user.dir")+"FailedTestsScreenshots/"+screenshotName + dateName +".png";
		
		File finalDestination = new File(destination);
		FileUtils.copyFile(source,finalDestination);
		return destination;
		
		
		
		
		
	}
	
	@BeforeMethod
	public void setuo() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://mta.multitechcorp.in/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
	//@Test(priority=1)
//	public void loginmta() throws InterruptedException {
		//LOGIN CRED:
		
		extentTest = extent.startTest("Login mta");
		
		WebElement enterUserName=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
		WebElement enterPassword =driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		WebElement clickLoginBtn =driver.findElement(By.xpath("//button[text()='Login']"));
		enterUserName.sendKeys("accounts@multitechcorp.in");
		enterPassword.sendKeys("mta@1234");
		clickLoginBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String expectedDashboardURL = "https://mta.multitechcorp.in/admin/dashboard?page=1";
        wait.until(ExpectedConditions.urlToBe(expectedDashboardURL));

		String actualDashBoardUrl = driver.getCurrentUrl();
		System.out.println("The actual url is"+actualDashBoardUrl);
		Assert.assertEquals(actualDashBoardUrl, expectedDashboardURL);
		
		Thread.sleep(5000);
	}
		
		@Test(priority=2)
		public void AddTeam() throws InterruptedException {
		WebElement clickAddTeamBtn = driver.findElement(By.xpath("//button[text()='ADD TEAM']"));
		Assert.assertTrue(clickAddTeamBtn.isDisplayed() && clickAddTeamBtn.isEnabled());
		clickAddTeamBtn.click();
		Thread.sleep(3000);
		}
		@Test(priority=3)
		public void TeamName() throws InterruptedException {
		WebElement enterNewTeamName = driver.findElement(By.xpath("//input[@formcontrolname='teamnam']"));
		enterNewTeamName.sendKeys("Automation test team");
		WebElement enterTeamDescription = driver.findElement(By.xpath("//div[@class='col-lg-6']/textarea[@formcontrolname='description']"));
		enterTeamDescription.sendKeys("Automation team document");
		WebElement clickAddTeamToCreateNewTeam = driver.findElement(By.xpath("(//button[text()='ADD TEAM'])[2]"));
		Assert.assertTrue(clickAddTeamToCreateNewTeam.isDisplayed() && clickAddTeamToCreateNewTeam.isEnabled());
		clickAddTeamToCreateNewTeam.click();
		Thread.sleep(4000);

		
		}
	
	
	

@AfterMethod
public void teardown(ITestResult result) throws IOException {
	
	if(result.getStatus()==ITestResult.FAILURE) {
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS"+""+result.getName());
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS"+""+result.getThrowable());
		
		String screenshotPath = demoScreenMT.getScreenShot(driver, result.getName());
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));  //to add screenshot in extent report
		extentTest.log(LogStatus.FAIL, extentTest.addBase64ScreenShot(screenshotPath));  //to add screenshot in extent report


	}
	else if(result.getStatus()==ITestResult.SKIP) {
		extentTest.log(LogStatus.SKIP, "Test Case SKIPPED is" +""+ result.getName());
		}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		extentTest.log(LogStatus.PASS, "Test Case PASSED is" +""+ result.getName());

	}
	
		extent.endTest(extentTest);  //ending test
		
	
	driver.quit();
}

	

		
		
	
}
