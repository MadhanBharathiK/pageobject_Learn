package Selenium_Concepts;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.interactions.Actions;


public class Mt_report {

	WebDriver driver;
	//@BeforeClass
	@Test(priority=1)
	public void setup() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://mta.multitechcorp.in/auth/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	//Login page:
	@Test(priority=2)
	public void loginmta() throws InterruptedException {
		//LOGIN CRED:
		WebElement enterUserName=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
		WebElement enterPassword =driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		WebElement clickLoginBtn =driver.findElement(By.xpath("//button[text()='Login']"));
		enterUserName.sendKeys("accounts@multitechcorp.in");
		enterPassword.sendKeys("mta@1234");
		clickLoginBtn.click();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // Wait for a maximum of 10 seconds
		
		//Assert Dashboard url:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String expectedDashboardURL = "https://mta.multitechcorp.in/admin/dashboard?page=1";
        wait.until(ExpectedConditions.urlToBe(expectedDashboardURL));

		String actualDashBoardUrl = driver.getCurrentUrl();
		System.out.println("The actual url is"+actualDashBoardUrl);
		Assert.assertEquals(actualDashBoardUrl, expectedDashboardURL);
	}
	
	//Dashboard Add team:
	@Test(priority=3)
	public void clickAddTeam() {
		//1. click add to create new team using automation :
		WebElement clickAddTeamBtn = driver.findElement(By.xpath("//button[text()='ADD TEAM']"));
		Assert.assertTrue(clickAddTeamBtn.isDisplayed() && clickAddTeamBtn.isEnabled());
		clickAddTeamBtn.click();
		}
	
	//Create a New Team:
	@Test(priority=4)
	public void CreateNewTeam() throws InterruptedException {
		WebElement enterNewTeamName = driver.findElement(By.xpath("//input[@formcontrolname='teamname']"));
		enterNewTeamName.sendKeys("Automation test team");
		WebElement enterTeamDescription = driver.findElement(By.xpath("//div[@class='col-lg-6']/textarea[@formcontrolname='description']"));
		enterTeamDescription.sendKeys("Automation team document");
		WebElement clickAddTeamToCreateNewTeam = driver.findElement(By.xpath("(//button[text()='ADD TEAM'])[2]"));
		Assert.assertTrue(clickAddTeamToCreateNewTeam.isDisplayed() && clickAddTeamToCreateNewTeam.isEnabled());
		clickAddTeamToCreateNewTeam.click();
		Thread.sleep(4000);

		}
	
	//Click three dot to add team user:
	@Test(priority=5)
	public void CreatedTeamThreeDotAddTeamUser() throws InterruptedException {
	
		WebElement CreatedTeamThreeDot = driver.findElement(By.xpath("(//i[@class='mat-menu-trigger fa fa-ellipsis-h'])[1]"));
		CreatedTeamThreeDot.click();
		
		//Add user into team:
		WebElement clickAddUserBtn = driver.findElement(By.xpath("//button[text()='Add users']"));
		Assert.assertTrue(clickAddUserBtn.isDisplayed() && clickAddUserBtn.isEnabled());
		clickAddUserBtn.click();
		Thread.sleep(5000);
	}
	@Test(priority=6)
	public void AddUserIntoTeam() throws InterruptedException {
		//Select userRole:
		WebElement UserRole = driver.findElement(By.xpath("//select[@formcontrolname='userName']"));
		Select selectUserRole = new Select(UserRole);
		selectUserRole.selectByVisibleText("STAFF");
		
		//Type userName and click checkbox:
		WebElement UserSearch = driver.findElement(By.xpath("(//input[@placeholder='Search'])[3]"));
		UserSearch.sendKeys("test user automation");
		Thread.sleep(2000);
		
		//CLICK CHECKBOX:
		WebElement UserSearchCheckBox = driver.findElement(By.xpath("//input[@formcontrolname='user_id']"));
		UserSearchCheckBox.click();
		
		//Add Selected user into team:
		WebElement AddTeamUser = driver.findElement(By.xpath("//button[text()='Add']"));
		AddTeamUser.click();
		Thread.sleep(4000);
		}
	
	//Add Project into Team:
	@Test(priority=7)
	public void threeDotToAddProject() {
		//click threee dot to addProject:
		WebElement CreatedTeamThreeDotAddProject = driver.findElement(By.xpath("(//i[@class='mat-menu-trigger fa fa-ellipsis-h'])[1]"));
		CreatedTeamThreeDotAddProject.click();
	}
	//Click AddProject button:
	@Test(priority=8)
	public void ClickAddProject() throws InterruptedException {
		WebElement AddProjectclick = driver.findElement(By.xpath("//button[text()='Add projects']"));
		AddProjectclick.click();
		Thread.sleep(2000);
		
		}
	
	//Search and Select Project :
	@Test(priority=9)
	public void SearchAndSelectProject() throws InterruptedException {
		//Search for Project to add in Created team:
		WebElement searchPorject = driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]"));
		searchPorject.sendKeys("Test Automation Project 01");
		
		//Click checkbox:
		WebElement ProjectCheckBox = driver.findElement(By.xpath("//input[@formcontrolname='project']"));
		ProjectCheckBox.click();
		//Add Project button:
		WebElement AddProjectBtnToTeam = driver.findElement(By.xpath("//button[text()='ADD PROJECT ']"));
		AddProjectBtnToTeam.click();
		Thread.sleep(3000);
	}
	//Double tap created team to open:
	@Test(priority=10)
	public void DoubleTapCreatedTeamToOpen() throws InterruptedException {
		WebElement doubleTap = driver.findElement(By.xpath("//*[text()='Automation team document']"));
		doubleTap.click();
		Thread.sleep(2000);
	}
	
	//Click Added Project threedot to Edit the Project:
	@Test(priority=11)
	public void EditProject() throws InterruptedException {
	WebElement EditProjectNameThreeDot = driver.findElement(By.xpath("//i[@class='mat-menu-trigger fa fa-ellipsis-h']"));
	EditProjectNameThreeDot.click();
	
	WebElement clickEditBtnToEdit = driver.findElement(By.xpath("//button[text()='Edit']"));
	clickEditBtnToEdit.click();
	Thread.sleep(3000);
	
	WebElement EditArea = driver.findElement(By.xpath("(//input[@formcontrolname='area'])[1]"));
	EditArea.clear();
	EditArea.sendKeys("Coimbatore");
	
	//Click Save after Editing:
	WebElement SaveEdit = driver.findElement(By.xpath("(//button[text()='EDIT PROJECT'])[1]"));
	SaveEdit.click();
	
	//Click confrim:
	WebElement UpdateAfterEditing = driver.findElement(By.xpath("//button[text()='Update']"));
	UpdateAfterEditing.click();
	Thread.sleep(5000);
	}
	
	//Click Added Project to open :
	@Test(priority=12)
	public void DoubleTopAddedProjectToOpen() {
		WebElement doubleTopAddedProject = driver.findElement(By.xpath("//span[text()='Test Automation Project 01']"));
		doubleTopAddedProject.click();
		
	}
	
	//Add user into Project:
	@Test(priority=13)
	public void AddUserIntoProject() throws InterruptedException {
		//Click Add user btn:
		WebElement clickAddusertoAddInProject = driver.findElement(By.xpath("//*[text()='Add User']"));
		clickAddusertoAddInProject.click();
		Thread.sleep(2000);
		
		//Select user:
		WebElement SelectProjectUser = driver.findElement(By.xpath("//select[@formcontrolname='userName']"));
		
		Select selectprojectuser = new Select(SelectProjectUser);
		selectprojectuser.selectByVisibleText("CONTRACTORS");
		
		//UserName search:
		WebElement usernameSearchForProject = driver.findElement(By.xpath("//input[@placeholder='Search User']"));
		usernameSearchForProject.sendKeys("test user manual");
		//Click Tester user checkbox:
		WebElement testuserCheckBox = driver.findElement(By.xpath("//input[@formcontrolname='user_id']"));
		testuserCheckBox.click();
		
		//Click Add btn to user into project :
		WebElement AdduserBtntoProject = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
		AdduserBtntoProject.click();
		Thread.sleep(3000);
	}
	
	//Click Document Tab after Adding user into project:
	@Test(priority=14)
	public void DocumentTabClick() {
	
		WebElement DocumentTabclick = driver.findElement(By.xpath("//a[text()='Documents']"));
		DocumentTabclick.click();
		
		
	}
	
	//Click + button to document globally:
	@Test(priority=15)
	public void HitPlusButtonToGlobalDoc() throws InterruptedException {
	//Click + button to Upload a document globally :
	WebElement GlobalDocPlusBtn = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]"));
	GlobalDocPlusBtn.click();
	Thread.sleep(2000);
	
	}
	
	@Test(priority=16)
	public void uplodDocumentGlobal() throws InterruptedException {
		//Upload document:
		WebElement UploadFileGlobal = driver.findElement(By.xpath("//input[@formcontrolname='filename']"));
		UploadFileGlobal.sendKeys("C:\\\\Users\\\\USER\\\\Pictures\\\\sample (1).pdf");
		
		//Enter Document Title :
		WebElement enterDocumentTitle = driver.findElement(By.xpath("//input[@formcontrolname='title']"));
		enterDocumentTitle.sendKeys("Uploading a global document");
		
		//Enter Doucment Description:
		WebElement enterDocumentDescr = driver.findElement(By.xpath("//textarea[@formcontrolname='description']"));
		enterDocumentDescr.sendKeys("This to upload the document related to test project");
		
		//Document final Upload button:
		WebElement clickDocUploadBtn = driver.findElement(By.xpath("//button[text()='Upload']"));
		clickDocUploadBtn.click();
		
		//Click confirm to upload a document:
		WebElement clickConfirmToUploadDocu = driver.findElement(By.xpath("//button[text()='Confirm']"));
		clickConfirmToUploadDocu.click();
		Thread.sleep(3000);
	}
	
	//Click Category:
	@Test(priority=17)
	public void clickCategory() throws InterruptedException {
		WebElement clickCategory = driver.findElement(By.xpath("//button[text()='Categories ']"));
		clickCategory.click();
		Thread.sleep(3000);
	}
	
	//Add / Map Category:
	@Test(priority=18)
	public void AddMapCategory() throws InterruptedException {
		WebElement AddMapCategoryBtn = driver.findElement(By.xpath("//button[text()='Add / Map Category']"));
		AddMapCategoryBtn.click();	
		Thread.sleep(2000);
	}
	
	//ScrollDown to Test house under Category:
	@Test(priority=19)
	public void ScrollDownInCategory() throws InterruptedException {
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
   // jsExecutor.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'nearest' });",driver.findElement(By.xpath("(//input[@formcontrolname='categoryname'])[52]")));
    
    jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//input[@formcontrolname='categoryname'])[52]")));
	Thread.sleep(3000);
	}
	
	@Test(priority=20)
	public void SelectCategroy() throws InterruptedException {
		//Click Test house Category checkbox:
		WebElement clickCategoryCheckbpx = driver.findElement(By.xpath("(//td[@class='col-md-1']/input[@formcontrolname='categoryname'])[52]"));
		clickCategoryCheckbpx.click();
	
		//Click Add Btn to Add Selected Categroy :
		WebElement clickAddToSelectCategory = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
		clickAddToSelectCategory.click();
		Thread.sleep(3000);
	}
	
	@Test(priority=21)
	//Click Added Category to open
	public void ClickAddedCategoryToOpen() throws InterruptedException {
		WebElement OpenAddedCategory = driver.findElement(By.xpath("//P[text()='test house']"));
		OpenAddedCategory.click();
		Thread.sleep(2000);
		
	}
	
	 @Test(priority=22)
	//Click Map user into Category:
	public void MapUserIntoCategory() throws InterruptedException {
		//Click Users button to add users into the category:
	   WebElement clickMapUserInCategory = driver.findElement(By.xpath("//button[text()='Map Use']"));
	   clickMapUserInCategory.click();
		 Thread.sleep(3000);
	 }
	// Add user into Cateogry By selecting the role:
	 @Test(priority=23)
	 public void SelectCategoryUser() throws InterruptedException {
		 //Select user role:
		 WebElement SelectCategoryUserRole = driver.findElement(By.xpath("//select[@placeholder='Select User']"));
		 Select selectCatUser = new Select(SelectCategoryUserRole);
		 selectCatUser.selectByVisibleText("STAFF");
		 
		 //Search users category:
		 WebElement SearchCategoryUserName = driver.findElement(By.xpath("//input[@placeholder='Search User']"));
		 SearchCategoryUserName.sendKeys("test user Automation");
		 
		 //Click CheckBox User Category:
		 WebElement clickCheckboxCatUserElement = driver.findElement(By.xpath("//input[@formcontrolname='user_id']"));
		 clickCheckboxCatUserElement.click();
		 
		 //Add button to add category user:
		 WebElement AddButtonCategoryUser = driver.findElement(By.xpath("(//button[text()='Add'])[1]"));
		 AddButtonCategoryUser.click();
		 Thread.sleep(3000);
		 
	 }
	 
	 @Test(priority=24)
	 public void CategoryDocClick() throws InterruptedException {
		 Thread.sleep(2000);
		 //Click Category Document:
		 WebElement clickCatorgyDocu = driver.findElement(By.xpath("//a[text()='Documents']"));
		 clickCatorgyDocu.click();
		 
		 //Click + plus button to Add Cateogry document:
		 WebElement catDocumentPlus = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		 catDocumentPlus.click();
		 Thread.sleep(2000);
		 
	 }
	 
	 @Test(priority=25)
	 public void UploadCategoryDocument() throws InterruptedException {
		 WebElement UploadFileCategory = driver.findElement(By.xpath("//input[@id='uploaddocs']"));
		 UploadFileCategory.sendKeys("C:\\\\\\\\Users\\\\\\\\USER\\\\\\\\Pictures\\\\\\\\sample (1).pdf");
		 
		 //Category Document Title:
		 WebElement CategoryTitle = driver.findElement(By.xpath("//input[@formcontrolname='title']"));
		 CategoryTitle.sendKeys("Category title updating");
		 
		 //Category Desc:
		 WebElement CategoryDesc = driver.findElement(By.xpath("//textarea[@formcontrolname='description']"));
		 CategoryDesc.sendKeys("Category Description to add document");
		 
		 //Category Upload:
		 WebElement CategoryUpload = driver.findElement(By.xpath("//button[text()='Upload']"));
		 CategoryUpload.click();
		 
		 //Category confirm the document upload:
		 WebElement ConfirmDocUpload = driver.findElement(By.xpath("//button[text()='Confirm']"));
		 ConfirmDocUpload.click();
		 Thread.sleep(15000);
		 
	 }
	
	 @Test(priority=26)
	 public void clickLogout() {
		 
		 driver.navigate().refresh();
		 WebElement elementToClick = driver.findElement(By.xpath("//*[text()='LOGOUT']"));
		 Actions action = new Actions(driver);
		 action.moveToElement(elementToClick).click().perform();
		 
		 
		 

	 }
		 

		}
	

