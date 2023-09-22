package xpath_pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class hey_xpath {
	
WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://mta.multitechcorp.in/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Browser Launched");
		
	}
	
	public void mtaLogin() {
		WebElement enteremail = driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
		enteremail.sendKeys("accounts@multitechcorp.in");
		WebElement enterpass = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		enterpass.sendKeys("mta@1234");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	
	}

}
