package mTA_Flow;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class mta_Log {

	WebDriver driver;

	@Test
	public void setup() {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
}
}
