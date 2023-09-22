package mySwanAdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DirectLocate {
	WebDriver driver;
	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\USER\\\\Desktop\\\\ChromeDriver jar\\\\chromedriver.exe");
		 driver= new ChromeDriver();
			driver.get("http://192.168.0.135:3000/employeeregister");
			driver.manage().window().maximize();
	        Thread.sleep(2000);


}
}
