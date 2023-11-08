package TestNGListnerConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(CustomListener.class)
public class ScreenShot_Onlyfor_FailedTest extends baseClass{

	@BeforeClass
	public void setUp() {
		
		initialization();
		}
	
	
	

	@AfterClass
	public void tearDown() {
	//	driver.quit();
	}

	@Test(priority=1)
	public void ClickSignWithGoogle() throws InterruptedException {
		WebElement TLloginUserName = driver.findElement(By.xpath("//input[@name='Email']"));
		WebElement TLloginPass = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement ClickTLLogin = driver.findElement(By.xpath("//BUTTON[text()='Sign In']"));
		
		TLloginUserName.sendKeys("rajkumar.r@skeintech.com");
		TLloginPass.sendKeys("1234");
		ClickTLLogin.click();
		Assert.assertTrue(ClickTLLogin.isSelected(), "Login button is not enabled ");
		Thread.sleep(3000);
		
		
	}
	
	
	
	
		
	
	
	
	
		}
	

