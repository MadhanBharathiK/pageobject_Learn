package mySwanAdd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class AddMember {
	WebDriver driver;
	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\USER\\\\Desktop\\\\ChromeDriver jar\\\\chromedriver.exe");
		 driver= new ChromeDriver();
			driver.get("http://192.168.0.135:3000");
			driver.manage().window().maximize();
	        Thread.sleep(2000);

	}
		//Valid Login:
		@Test(priority=0)
		public void verfiyLoginPage() throws InterruptedException {
			//Verify Title:
			String expectedTitle ="Swan HR Portal";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Title Matched:"+actualTitle);
			
		// Verify LOGOimage:
			boolean SwanLogo = driver.findElement(By.xpath("//img[@src='static/images/logo-white.png']"))
					.isDisplayed();
			Assert.assertTrue(SwanLogo);
			System.out.println("Swan Logo Present:"+""+SwanLogo);
		
		
		//Verify LandingPage Image:
	   	boolean LandingPage = driver.findElement(By.xpath("//img[@src='static/images/Landing-IMG.png']"))
				.isDisplayed();
		   Assert.assertTrue(LandingPage);
		   System.out.println("LandingPage is Present:"+""+LandingPage);
		   
		//Verify buttons in Login:
		   //Employee button:
		   boolean EmployeeBtn = driver.findElement(By.xpath("//button[contains(text(),'Employee')]")).isDisplayed();
		   Assert.assertTrue(EmployeeBtn);
		   System.out.println("Employee Button is Present:"+""+EmployeeBtn);
		   
		   //Hr button:
		   boolean HRBtn = driver.findElement(By.xpath("//button[contains(text(),'HR Team')]")).isDisplayed();
		   Assert.assertTrue(HRBtn);
		   System.out.println("HR Button is Present:"+""+HRBtn); 
		   
		   //Admin button:
		   boolean AdminBtn =driver.findElement(By.xpath("//button[contains(text(),'Swan Team')]")).isDisplayed();
		   Assert.assertTrue(AdminBtn);
		   System.out.println("Admin Button is Present:"+""+AdminBtn); 
			Thread.sleep(5000);
			//Refresh a page:
		    driver.navigate().refresh();
	}
		
			
		
		@Test(priority=2)
		public void loginHR() throws InterruptedException {
			//click subhr:
			WebElement subrClick = driver.findElement(By.xpath("//*[@id=\"root\"]/main/button[2]"));
			subrClick.click();
			Thread.sleep(5000); 
			//Enter email :
			WebElement HrEmail =driver.findElement(By.xpath("//*[@id=\":r0:\"]"));
			HrEmail.sendKeys("subhr@gmail.com");
			//Enter HrPassword:
			WebElement hrPassword = driver.findElement(By.xpath("//*[@id=\":r1:\"]"));
			hrPassword.sendKeys("qwerty");
			//LoginBtn:
			WebElement hrLoginbtn = driver.findElement(By.xpath("//*[@id=\":r2:\"]"));
			hrLoginbtn.click();
			Thread.sleep(3000);
		}
		
		@Test(priority=3)
		public void clickCompaniesLink() throws InterruptedException {
			//click Companies link in Dashboard:
			Thread.sleep(5000);
			WebElement companyLink= driver.findElement(By.xpath("//a[@href='/companies']"));
			companyLink.click();
			driver.navigate().refresh();
			Thread.sleep(5000);
			}
		
		@Test(priority=4)
		public void clickCompanyName() {
			//Click CompanyName:
			WebElement companyName = driver.findElement(By.xpath("//p[contains(text(),'LAVASTONE PROPERTIES LTD')]"));
			companyName.click();
		}
		
		//Click AddEmployee
		@Test(priority=5)
		public void clickAddEmployee() throws InterruptedException {
			WebElement AddEmployeeBtn = driver.findElement(By.xpath("//*[contains(text(),'Add Employee')]"));
			AddEmployeeBtn.click();
			Thread.sleep(2000);
		}
		
		//Add-Employee details:
		@Test(priority=6)
		public void AddEmployee() throws InterruptedException {
			//EmpID:
			Thread.sleep(2000);
			WebElement EmpId = driver.findElement(By.xpath("//input[@name='employeeid']"));
			EmpId.click();
			EmpId.sendKeys("EMP001");
			String valEmpId = EmpId.getAttribute("value");
			System.out.println("Employee Id:"+""+EmpId);
			
			//ForeName:
			WebElement empForeName = driver.findElement(By.xpath("//input[@name='forename']"));
			empForeName.sendKeys("Dominic");
			String valempForeName = empForeName.getAttribute("value");
			System.out.println("Employee ForeName"+""+valempForeName);
			
			//SurName:
			WebElement empUserName = driver.findElement(By.xpath("//input[@name='surname']"));
			empUserName.sendKeys("SR");
			String valempUserName = empUserName.getAttribute("value");
			System.out.println("empUserName"+""+empUserName);
			
			//Email:
			WebElement empEmail = driver.findElement(By.xpath("//input[@name='email_id']"));
			empEmail.sendKeys("madhanbharathi@skeintech.com");
			String valempEmail = empEmail.getAttribute("value");
			System.out.println("Employee Email"+""+valempEmail);
			//DOB:	
			WebElement empDOB = driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']"));
			empDOB.sendKeys("25/07/1999");
			String valempDOB = empDOB.getAttribute("value");
			System.out.println("DOB"+""+valempDOB);
			//Gender:
			WebElement empGender = driver.findElement(By.xpath("//input[@name='gender' and @value='male']"));
			empGender.click();
			
			
			//SavebtnClick:
			WebElement clickSave = driver.findElement(By.xpath("//*[contains(text(),'Save & Next')]"));
			clickSave.click();
			Thread.sleep(2000);
		}
			//Click Fill the Form Now:	
			@Test(priority=7)
			public void clickFillForm() throws InterruptedException {
				WebElement clickFormNow = driver.findElement(By.xpath("//*[contains(text(),'Fill the form now')]"));
				clickFormNow.click();
				Thread.sleep(11000);
			}
			//Scroll Down:
			@Test(priority=8)
			public void scrolltosurname() {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement element = driver.findElement(By.xpath("//input[@name='surname']"));
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				}
			
			//Fill Employee Register Form:
			@Test(priority=9)
			public void fillEmployeeRegisterForm() throws InterruptedException {
				//Click Mauritian:
				WebElement ClickMauritian = driver.findElement(By.xpath("//input[@name='is_mauritian']"));
				ClickMauritian.click();
			
				//Enter NIC:
				WebElement enterNIC = driver.findElement(By.xpath("//input[@name='nic_no']"));
				enterNIC.sendKeys("V7896587458965");
				Thread.sleep(5000);
				
				
				//Select Marital Status:
				WebElement ClickMaritalDropdown = driver.findElement(By.xpath("//*[@id=\"mui-component-select-marital_status\"]"));
				ClickMaritalDropdown.click();
				
				//select option from dropdown:
				WebElement SelectMaritalStatus = driver.findElement(By.xpath("//*[@id=\"menu-marital_status\"]/div[3]/ul/li[1]"));
				SelectMaritalStatus.click();
				
				//Phone Number Home:
				WebElement PhoneHome = driver.findElement(By.xpath("//input[@name='phone_no_home']"));
				PhoneHome.sendKeys("55458");
				String valPhoneHome = PhoneHome.getAttribute("value");
				System.out.println("Phone Number Home"+""+valPhoneHome);
				//Phone  Number Mobile:
				WebElement phoneMobile = driver.findElement(By.xpath("//input[@name='phone_no_mobile']"));
				phoneMobile.sendKeys("554558");
				String valphoneMobile = phoneMobile.getAttribute("value");
				System.out.println("Phone Mobile"+""+valphoneMobile);
				
				//Phone Number OFFICE:
				
				WebElement phoneOffice = driver.findElement(By.xpath("//input[@name='phone_no_office']"));
				phoneOffice.sendKeys("5558");
				Thread.sleep(3000);

				}
			//Scroll down to Address
			@Test(priority=10)
			public void scrolldowntoAddressHR() throws InterruptedException {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement element = driver.findElement(By.xpath("//input[@name='phone_no_mobile']"));
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				
				//Enter Address1:
				WebElement enterAddress1 = driver.findElement(By.xpath("//input[@name='address_1']"));
				enterAddress1.sendKeys("cbe");
				String valenterAddress1 = enterAddress1.getAttribute("value");
				System.out.println("Address1"+""+valenterAddress1 );
				//Enter Address2:
				WebElement enterAddress2 = driver.findElement(By.xpath("//input[@name='address_2']"));
				enterAddress2.sendKeys("cbe");
				String valenterAddress2 = enterAddress2.getAttribute("value");
				System.out.println("Address2"+""+valenterAddress2 );

				//Select City:
				WebElement clickSelectCity = driver.findElement(By.xpath("//*[@id=\"mui-component-select-city\"]"));
				clickSelectCity.click();
				Thread.sleep(3000);
				//Select city from dropdown:
				WebElement SelectCityDrop = driver.findElement(By.xpath("//*[@id=\"menu-city\"]/div[3]/ul/li[3]"));
				SelectCityDrop.click();
							
				//Click Pensior:
				WebElement cilckPensior = driver.findElement(By.xpath("//input[@name='is_pensioner']"));
				cilckPensior.click();
				
				//Click Card 
				WebElement cilckCard = driver.findElement(By.xpath("//input[@name='card' and @value='digital']"));
				cilckCard.click();
				Thread.sleep(5000);
				
				//FileUpload BirthCertificate:
				WebElement BirthFile = driver.findElement(By.xpath("//input[@name='birthcertificate']"));
				BirthFile.sendKeys("C:\\Users\\USER\\Pictures\\sample (1).pdf");
				//NIC upload:
				WebElement NICFile = driver.findElement(By.xpath("//input[@name='identitycard']"));
				NICFile.sendKeys("C:\\\\Users\\\\USER\\\\Pictures\\\\sample (1).pdf");
				Thread.sleep(2000);
				}
			
				//ScrollDowntoEnd HR:   
				@Test(priority=11)
				public void scrollToEndHr() throws InterruptedException {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,440)", "");
					Thread.sleep(5000);
					//Select ClickbanknameDrpoDown:
					
					WebElement ClickbanknameDrpoDown =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/main/div/div[2]/form/div[2]/div/div/div/div/div[12]/div[1]/div/div/div"));
					ClickbanknameDrpoDown.click();
					Thread.sleep(2000);
					
					//Select bankname:
				
					WebElement SelectBank = driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[3]"));
					SelectBank.click();
					Thread.sleep(3000);
					
					//Bank Account Number:15
					WebElement BankAccountNumber = driver.findElement(By.xpath("//input[@name='bank_account_number']"));
					BankAccountNumber.sendKeys("789658745896585");
					Thread.sleep(3000);
					
					//File Upload bank proff document:
					WebElement proff = driver.findElement(By.xpath("//input[@name='proof']"));
					proff.sendKeys("C:\\\\Users\\\\USER\\\\Pictures\\\\sample (1).pdf");
					Thread.sleep(3000);
					
					//scroll:
					JavascriptExecutor jjs = (JavascriptExecutor) driver;
					jjs.executeScript("window.scrollBy(0,440)", "");
					Thread.sleep(3000);  
					
					//DOE:
					WebElement DOE = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > main:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(18) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)"));
					DOE.click();
					DOE.sendKeys("07/07/2023");
					Thread.sleep(5000);
					
					//Principal Member Save Button:
					WebElement PrincipalMemberSaveBtn = driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.makeStyles-saveAndNextButtonStyle-86.css-1ja87p4-MuiButtonBase-root-MuiButton-root"));
					PrincipalMemberSaveBtn.click();
					
					
					
					
					
					
					
					
					
					
					
				}}

