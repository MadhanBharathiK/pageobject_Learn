package MTAPack;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;


import org.openqa.selenium.support.ui.Select;

public class MtaLogin {
	WebDriver driver;
	@Test(priority=0)
	public void Setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\USER\\\\Desktop\\\\ChromeDriver jar\\\\chromedriver.exe");
		 driver= new ChromeDriver();
			driver.get("https://demo.emeetify.com:5010/auth/login");
			driver.manage().window().maximize();
	        Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		
	//EMail:
		WebElement Email = driver.findElement(By.xpath("//input[@type='text']"));
		Email.sendKeys("accounts@multitechcorp.in");
		
	//Password:
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("mta@1234");
	//click login;
		WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		login.click();
		Thread.sleep(8000);
		
		}
	
	@Test(priority=2, enabled = false )
	public void AddTeam() throws InterruptedException {
		//Click AddTeam Btn:
		WebElement AddTeam = driver.findElement(By.xpath("//button[normalize-space()='ADD TEAM']"));
		AddTeam.click();
		Thread.sleep(4000);  
		
		}
	
	//Add New Team:  enabled = false
	@Test(priority=3 )
	public void AddNewTeam() throws InterruptedException {
		//Enter Team Name :
		Thread.sleep(2000);
		WebElement EnterTeamName = driver.findElement(By.xpath("//input[@formcontrolname='teamname']"));
		EnterTeamName.sendKeys("Test SKN");
		Thread.sleep(4000);

		//Description:
		WebElement EnterDesc = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/textarea[1]"));
		EnterDesc.click();
		EnterDesc.sendKeys("SKN DS");
		Thread.sleep(3000);
		
		//Click AddTEAM :
		WebElement ClickAddTeam = driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='ADD TEAM'])[2]"));
		ClickAddTeam.click();
		Thread.sleep(3000);
		}
	
	//Add Project: enabled = false
	@Test(priority=4)
	public void AddProject() throws InterruptedException {
		//Click ThreeDot:
		WebElement clickthreeDot = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[2]/div[1]/div[9]/div[1]/i[1]"));
		clickthreeDot.click();
		
		//Click AddProject:
		WebElement AddProjectIntoTeam = driver.findElement(By.xpath("(//button[normalize-space()='Add projects'])[1]"));
		AddProjectIntoTeam.click();
		Thread.sleep(5000);
		
		//Scroll down to Test Automative:
		JavascriptExecutor scrolltoProject = (JavascriptExecutor) driver;
		scrolltoProject.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//td[normalize-space()='Test Automative'])[1]")));
		
		//Click Test Automative :
		WebElement clickTestAutomative = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[64]/td[3]/input[1]"));
		clickTestAutomative.click();
		
		
		//keydown:
   		WebElement elements = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[64]/td[3]/input[1]"));
		elements.sendKeys(Keys.PAGE_DOWN);
		elements.sendKeys(Keys.PAGE_DOWN);   
	}
		//Click Project: enabled = false
		@Test(priority=5)
		public void ClickAddProject() throws InterruptedException {
		WebElement selectandAddProject = driver.findElement(By.xpath("//div[@id='addProjectModal']//button[@type='submit'][normalize-space()='ADD TEAM']"));
		selectandAddProject.click();
		Thread.sleep(7000);
		}
		
		//Click To View Project:
		@Test(priority=6)
		public void ClickToViewProject() throws InterruptedException {
		WebElement ClickToViewProject = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-teams[1]/div[1]/div[1]/div[2]/div[1]/div[9]/div[1]/div[2]/div[1]"));
		ClickToViewProject.click();
		Thread.sleep(5000);
		
		}
		
		//ClickProject To Add User :
		@Test(priority=7)
		public void ClickProject() {
			WebElement clickproject = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-dashboard[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/p[1]"));
			clickproject.click();
			}
		
		//Add User Into Project:
		@Test(priority=8)
		public void clickAdduser() throws InterruptedException {
			WebElement clickAddUser= driver.findElement(By.xpath("(//a[normalize-space()='Add User'])[1]"));
			clickAddUser.click();
			Thread.sleep(4000);
			
		}
		
		//Select User Role:
		@Test(priority=9)
		public  void SelectRole() throws InterruptedException {
		
			//Select User Role From the Dropdown:
			Select RoleDrop = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-project-details[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/select[1]")));
			RoleDrop.selectByIndex(2);
			Thread.sleep(3000);
			
			 
			//Scroll down to Select Role Btn :
			JavascriptExecutor SelectRoleBtn = (JavascriptExecutor) driver;
			SelectRoleBtn.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-project-details[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[23]/td[2]")));
			Thread.sleep(3000);
			//Select Users to add into project:
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-project-details[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[21]/td[3]/input[1]")).click();
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-project-details[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[22]/td[3]/input[1]")).click();
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-project-details[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[23]/td[3]/input[1]")).click();
			
			//Click SelectRole Add btn:
			WebElement SelectRoleAddBtn = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-super-admin[1]/div[1]/div[1]/div[1]/app-project-details[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[2]/div[1]/button[1]"));
			SelectRoleAddBtn.click();
			Thread.sleep(4000);
			}
		
		//Upload Document as Global user
		@Test(priority=10)
		public void clickDocumentTab() throws InterruptedException {
			WebElement clickDocumentTab = driver.findElement(By.xpath("//a[@id='document-tab']"));
			clickDocumentTab.click();
			Thread.sleep(3000);
			
			//Click + symbol to add the document :
			WebElement plusSymbol = driver.findElement(By.xpath("//button[@class='btn btn-bg btn-primary app-bg add-files ng-star-inserted']"));
			plusSymbol.click();
			Thread.sleep(7000);
			
			//Upload a Document File:
			driver.findElement(By.xpath("//input[@id='uploaddocs']")).sendKeys("C:\\Users\\USER\\Pictures\\sample (1).pdf");
			
			//Enter Global Title:
			WebElement GlobalTitle = driver.findElement(By.xpath("//input[@formcontrolname='title']"));
			GlobalTitle.sendKeys("Global document 1");
			Thread.sleep(3000);
			
			//Enter Global Description:
			WebElement GlobalDesc = driver.findElement(By.xpath("//textarea[@type='text']"));
			GlobalDesc.sendKeys("Adding Document for Global user 1");
			
			//Upload Btn for Global document :
			WebElement clickonGlobalUploadBtn = driver.findElement(By.xpath("//button[normalize-space()='Upload']"));
			clickonGlobalUploadBtn.click();
			Thread.sleep(3000);
			//Handle Alert :
	        Alert alert = driver.switchTo().alert();
	        alert.accept();

			
			}
		
		
		
		
		
	}
	
		
			
			
	   
		

	
	
	
	
	
