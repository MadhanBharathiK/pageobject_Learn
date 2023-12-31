package testcases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pages.login;
import pages.HomePage;

public class testLogin {
	
	

	//public static void main(String[] args) throws InterruptedException {
	WebDriver driver;
	
	public login lg;
	public	HomePage home;
	
	@Test(priority=1)
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver.exe");

		
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Browser Launched");
		
	}
	@Test(priority=2)
	public void testLogin() throws InterruptedException {
		//Creating Object of login page:
		
		login lg = new login(driver);
		
		//Enter username & password
		lg.enterusername("Admin");
		lg.enterpassword("admin123");
	//	Thread.sleep(6000);
		lg.clickLogin();
		
	
	
	//Home Page test:
	HomePage home = new HomePage(driver);
	
		boolean isDashboardDisplayed = home.isDashboardDisplayed();
		
		Assert.assertTrue(isDashboardDisplayed, "Dashboard logo is not displayed.");
		
		Thread.sleep(4000);
	
		home.clickMyInfoOnDashboard();
		
		
		
	
	

	}
}

