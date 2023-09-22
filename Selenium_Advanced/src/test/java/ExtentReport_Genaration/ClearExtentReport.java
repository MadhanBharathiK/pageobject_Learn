package ExtentReport_Genaration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ClearExtentReport {

	WebDriver driver;
	ExtentReports extentReport;
	ExtentSparkReporter SparkReporter;
	ExtentTest testcase;
	
	@BeforeClass
	public void setups() {
		//Setting up the Browser:
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Setting the Extent Reports:
		extentReport=new ExtentReports();
		SparkReporter=new ExtentSparkReporter("ClearExtentReport.html");
		extentReport.attachReporter(SparkReporter);
		
		//Setting congfiguration:
		SparkReporter.config().setTheme(Theme.DARK);
		SparkReporter.config().setDocumentTitle("Automation Report");
		SparkReporter.config().setReportName("Demo Extent Report");
		extentReport.attachReporter(SparkReporter);
		
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		String LoginActualTitle = driver.getTitle();
		String LoginExpectedTitle = "MTA Architects";
		
		testcase = extentReport.createTest("Verify Page Title","Hey Verifying pages below");
		
		if(LoginActualTitle.equals(LoginExpectedTitle)) {
			testcase.log(Status.PASS, "Titlematched");
		}
		else {
			testcase.log(Status.FAIL, "Title not matched");
	}
	}
		
	@Test(priority=2)
	public void verifyLogin() throws IOException {
		
		WebElement user = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-auth[1]/app-login[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/input[1]"));
		user.sendKeys("accounts@multitechcorp.in");
		testcase = extentReport.createTest("VerifyLogin","Hey there Iam Verifying Login pages");
		testcase.info("Entering UserEmail");
		//password:
		WebElement enterpass = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-auth[1]/app-login[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/input[1]"));
		enterpass.sendKeys("mta@1234");
		testcase.info("Entering Password");
		//Login click:
		WebElement clickLogin = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-auth[1]/app-login[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]"));
		clickLogin.click();
		testcase.pass("Login SuccessFull");
		
		//Take ScreenShot:
				TakesScreenshot screenshot =(TakesScreenshot)driver;
				File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
				File destinationFile = new File("scr.png");
				FileHandler.copy(sourceFile, destinationFile);
				testcase.addScreenCaptureFromPath("scr.png");
				
		}
		
	@Test(priority=3)
	public void verifyDashBoardAddTeamBtn() {
		
		WebElement DashboardAddTeam = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[1]/div[4]/button[1]"));
		DashboardAddTeam.click();
		testcase= extentReport.createTest("Verify Dashboard AddTeam Button").assignAuthor("Madhan").assignCategory("Smoke");
		testcase.info("Clicking AddTeam button");
	}
	
	@Test(priority=4)
	public void CreateNewTeam() throws InterruptedException {
		
		testcase= extentReport.createTest("Verify Create New Team","Verifying Creating New Team").assignAuthor("Madhan").assignAuthor("Smoke");

		WebElement enterTeamName = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]"));
		enterTeamName.sendKeys("Test Automation Team");
		testcase.info("Entering TeamName");
		
		//Enter Descr:
		WebElement enterTeamDes = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/textarea[1]"));
		enterTeamDes.sendKeys("Automation testing team");
		testcase.info("Entering Team Description");

		//CLICK ADD TEAM:
		WebElement clickTeamSumbit = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[3]/div[1]/button[1]"));
		clickTeamSumbit.click();
		testcase.info("Clicking on Submit button");
		testcase.pass("New Team Created");
		driver.navigate().refresh();
		Thread.sleep(7000);
		testcase.info("Navigating back to Dashboard");
		}
	
	@Test(priority=5)
	public void ClickThreeDotForAddTeamUser() throws InterruptedException {
		testcase= extentReport.createTest("Verify ThreeDot Displayed","Verifying ThreeDot Displayed").assignAuthor("Madhan").assignCategory("Smoke");

		WebElement createdTeamDot = driver.findElement(By.xpath("//*[@id=\"content-togg\"]/div/app-teams/div/div/div[2]/div/div[9]/div/i"));
		createdTeamDot.click();
		testcase.info("Clicking threeDots");
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void AddUserToTeam() throws InterruptedException, IOException {
		testcase= extentReport.createTest("Verify Add User to Team","Verifying Add User to Team").assignAuthor("Ajith").assignCategory("Sanity");
		
		WebElement ClickAddUser = driver.findElement(By.xpath("//button[text()='Add users']"));
		ClickAddUser.click();
		testcase.info("Clicking AddUser Button");
		Thread.sleep(5000);
		testcase= extentReport.createTest("Verify Add User to Team","Verifying Add User to Team").assignAuthor("Ajith").assignCategory("Sanity");

		WebElement UserDropDown = driver.findElement(By.xpath("//select[@formcontrolname='userName']"));
		Select selectdrop = new Select(UserDropDown);
		selectdrop.selectByVisibleText("STAFF");
		testcase.info("Selecting from Dropdown");
		testcase= extentReport.createTest("Verify Add User to Team","Verifying Add User to Team").assignAuthor("Ajith").assignCategory("Sanity");

		//Click Select UserName:
		WebElement clickUserCheckBox = driver.findElement(By.xpath("//*[@id=\"adduserModal\"]/div/div/div[2]/form/div[1]/div[2]/div/table/tbody/tr[1]/td[3]/input"));
		clickUserCheckBox.click();
		testcase.info("Selecting user checkbox");
		Thread.sleep(3000);
		
		//Scroll To End of the page:
		JavascriptExecutor ScrollToEndUser = (JavascriptExecutor) driver;
		ScrollToEndUser.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[25]/td[3]/input[1]")));
		
		//Click Add Btn after Selecting User:
		WebElement AddSelectedUser = driver.findElement(By.xpath("//button[text()='Add']"));
		AddSelectedUser.click();
		testcase.log(Status.FAIL,"User Added Successfully");
		Thread.sleep(3000);
		

	}
	
	
	
	
	@AfterClass
		public void teardowns() {
			
			driver.quit();
			extentReport.flush();
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	

