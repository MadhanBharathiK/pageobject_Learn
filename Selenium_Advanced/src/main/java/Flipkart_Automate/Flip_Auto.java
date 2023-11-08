package Flipkart_Automate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flip_Auto {
	
	WebDriver driver;
	@Test
	public void setupFlip() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	
	
	 driver=new ChromeDriver();
	driver.get("https://mta.multitechcorp.in/auth/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority=1)
	public void login() {
		driver.findElement(By.xpath("//input[@formcontrolname='email_id']")).sendKeys("accounts@multitechcorp.in");
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("mta@1234");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	@Test(priority=2)
	public void CreateNewTeam() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='ADD TEAM']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@formcontrolname='teamname']")).sendKeys("Automation test team");
		driver.findElement(By.xpath("//div[@class='col-lg-6']/textarea[@formcontrolname='description']")).sendKeys("auto test desc");
		driver.findElement(By.xpath("//div[@class='text-center']/button[text()='ADD TEAM']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='dashCard']/i[@class='mat-menu-trigger fa fa-ellipsis-h'])[1]")).click();
	}
}
