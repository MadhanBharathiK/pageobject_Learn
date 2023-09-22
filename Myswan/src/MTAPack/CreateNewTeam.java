package MTAPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewTeam {
	WebDriver driver;
	@Test(priority=0)
	//Setup

	public void Setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\USER\\\\Desktop\\\\ChromeDriver jar\\\\chromedriver.exe");
		 driver= new ChromeDriver();
			driver.get("https://demo.emeetify.com:5010/auth/login");
			driver.manage().window().maximize();
	        Thread.sleep(3000);
	}
	
	//Login 
	@Test(priority=1)
	
	public void Login() throws InterruptedException {
		//EMail:
		WebElement Email = driver.findElement(By.xpath("//input[@type='text']"));
		Email.sendKeys("accounts@multitechcorp.in");
		
	//Password:
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("mta@1234");
	//click login;
		WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		login.click();
		System.out.println("Login Successfull");
		Thread.sleep(4000);
	//Assert Title:
		String actualTile = driver.getTitle();
		String ExceptedTitle = "MTA Architects";
		Assert.assertEquals(actualTile, ExceptedTitle,"Page Title Doesnot Match");
	}
	
	//Click Add Team Btn for Creating New Team:  ,enabled = false  
		@Test(priority=2,description="Create New Team")
		
		public void CreateNewTeam() throws InterruptedException {
		WebElement ClickAddTeamBtn = driver.findElement(By.xpath("//button[normalize-space()='ADD TEAM']"));
		Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='ADD TEAM']")).isEnabled());
		ClickAddTeamBtn.click();
		Thread.sleep(3000);
		
		
	//Enter New Team Name:
		WebElement EnterTeamName = driver.findElement(By.xpath("//input[@formcontrolname='teamname']"));
		EnterTeamName.sendKeys("Team MTA Test");
	//Enter Description Name:
		WebElement EnterDescription = driver.findElement(By.xpath("//div[@class='col-lg-6']//textarea[@type='text']"));
		EnterDescription.sendKeys("Builder the Best");
	//Click AddBtn after Entering details:
		WebElement clickAddTeamSubmit = driver.findElement(By.xpath("//div[@id='gymModal']//button[@type='submit'][normalize-space()='ADD TEAM']"));
		clickAddTeamSubmit.click();
		System.out.println("New Team Created Successfully");
		}
		
}
