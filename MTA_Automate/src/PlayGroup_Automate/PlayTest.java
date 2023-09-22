package PlayGroup_Automate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

public class PlayTest {
	WebDriver driver;

	
	@BeforeClass
	public void setup() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver.exe");
		  driver=new ChromeDriver();
			driver.get("https://demo.emeetify.com:81/playgroup/admin/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	//Verify Title
	@Test (priority=1)
	public void verifyTitle() {
		String ExcptedTitle = "Play Group :: Login";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExcptedTitle, ExcptedTitle);
	}
	
	//Verify Valid LOGIN :
	@Test(priority=2)
	public void verifyValidLogin() {
		WebElement enterusername = driver.findElement(By.xpath("//input[@id='email']"));
		enterusername.sendKeys("colalvirus@gmail.com");
		WebElement enterpassword = driver.findElement(By.xpath("//input[@id='password']"));
		enterpassword.sendKeys("Rajeesh@123#");
		WebElement clickLogin = driver.findElement(By.xpath("//input[@id='submit-button']"));
		clickLogin.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test(priority=3)
	public void validateDashBoard() throws InterruptedException {
		WebElement clickUserMenu = driver.findElement(By.xpath("//span[normalize-space()='Users']"));
		clickUserMenu.click();
		
		//Click AddUser:
		WebElement ClickAddUser = driver.findElement(By.xpath("//button[normalize-space()='Add User']"));
		ClickAddUser.click();
		
		//Enter Add UserName:
		WebElement AddUserName = driver.findElement(By.xpath("//input[@id='username']"));
		AddUserName.sendKeys("Auto Test user");
		
		//Enter EmailId:
		WebElement AddEmailId = driver.findElement(By.xpath("//input[@id='email']"));
		AddEmailId.sendKeys("AutoTestUser@gmail.com");
	
		//Enter PhoneNumber :
		WebElement AddPhoneNumber = driver.findElement(By.xpath("//input[@id='phoneno']"));
		AddPhoneNumber.sendKeys("990909909");
		//Thread.sleep(3000);

		//Click Country dropdown:
		WebElement countryDrop = driver.findElement(By.xpath("//span[normalize-space()='Select country']"));
		countryDrop.click();
		
		//Search & Select country
		WebElement searchCountry = driver.findElement(By.xpath("//div[@id='country_chosen']//input[@type='text']"));
		searchCountry.sendKeys("Afghanistan");
		searchCountry.sendKeys(Keys.RETURN);
		
		//Click Location dropdown:
		WebElement clicklocationDrop = driver.findElement(By.xpath("//span[normalize-space()='Select Location']"));
		clicklocationDrop.click();
		Thread.sleep(3000);
		//Serach & Select Location :
		WebElement searchLocation = driver.findElement(By.xpath("//div[@id='location_chosen']//input[@type='text']"));
		searchLocation.sendKeys("Andkhoy");
		searchLocation.sendKeys(Keys.RETURN);
		
		//SetPassword:
		WebElement setpassword = driver.findElement(By.xpath("//input[@id='password']"));
		setpassword.sendKeys("Test@123");
		
		//ConfrimPassword:
		WebElement confpassword = driver.findElement(By.xpath("//input[@id='confirmpassword']"));
		confpassword.sendKeys("Test@123");
		
		//Click Save:
		WebElement clickSave = driver.findElement(By.xpath("//input[@id='adduser-submit']"));
		clickSave.click();
	}

}
