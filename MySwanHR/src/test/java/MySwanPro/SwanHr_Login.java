package MySwanPro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class SwanHr_Login {
	WebDriver driver;

	
	@BeforeClass
	public void setup() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver.exe");
		  driver=new ChromeDriver();
			driver.get("http://192.168.0.148:3001/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority=1)
	public void VerifyHrTeam() {
		
		driver.findElement(By.xpath("//button[normalize-space()='HR Team']")).click();
		
	}

}
