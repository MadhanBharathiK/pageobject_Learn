package MTA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MTA_Flow {
	
	WebDriver driver;

	 @Test

	public void setup() {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/auth/login");
	 
	 }

}
