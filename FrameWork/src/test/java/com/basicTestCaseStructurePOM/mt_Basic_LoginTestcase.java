package com.basicTestCaseStructurePOM;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import com.basicPageElementStructurePOM.mt_Basic_LoginPageElement;


public class mt_Basic_LoginTestcase {

	@Test
	public void mtlogin() throws InterruptedException {
		//setting chromedriver path:
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver.exe");
		
		 //Intalizing the ChromeDriver:
		 WebDriver driver=new ChromeDriver();
		 
		 //getting the url:
		 driver.get("http://localhost:4200/auth/login");
		Thread.sleep(5000);
		/*
		 //Creating object for pageclass:
		 mt_Basic_LoginPageElement loginpageElement = new mt_Basic_LoginPageElement();
		 loginpageElement.findUsername(driver);
		 
		 */
		 
		 //Creating All WebElement methods with Static keyword and can call directly by using its class name
		 //without creating any object:
		 mt_Basic_LoginPageElement.findUsername(driver).sendKeys("accounts@multitechcorp.in");
		 mt_Basic_LoginPageElement.findPassword(driver).sendKeys("mta@1234");
		 mt_Basic_LoginPageElement.clickingLoginBtn(driver).click();
		 
		 
		 
		 
		 
	}
	
	
}
