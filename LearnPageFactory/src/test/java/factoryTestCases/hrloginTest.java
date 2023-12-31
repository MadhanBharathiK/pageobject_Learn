package factoryTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import factoryLoginPage.hrloginpage;
import factoryLoginPage.hrDashBoard;
public class hrloginTest {

	WebDriver driver;	
	hrloginpage hrlog;
	hrDashBoard dash ;
	
	//public static void main(String[] args)
	@BeforeClass
		public void setup() throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver.exe");
		
		
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Browser Launched");
		Thread.sleep(5000);
	}
	
		@Test(priority=1)
		public void verifyLogin() throws InterruptedException {
		hrloginpage hrlog = new hrloginpage(driver);
		hrlog.EnterUserName("Admin");
		hrlog.EnterUserPassword("admin123");
		hrlog.ClickLoginBtn();
		Thread.sleep(5000);
		}
		
		
		//Verify Dashboard:
		@Test(priority=2)
		public void Dashboard() throws InterruptedException {
		hrDashBoard dash = new hrDashBoard(driver);
		Assert.assertTrue(dash.isDashboardIconDisplayed());
		Thread.sleep(5000);
		
		//click MyInfoMenu:
		dash.clickMyInfoMenu();
		
	}
	
	
	
	
	
	}


