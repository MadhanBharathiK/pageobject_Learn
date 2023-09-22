package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	
	WebDriver driver;
	
	public login(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	//local username:
	By lusername = By.xpath("//input[@name='username']");
	By lpass = By.xpath("//input[@name='password']");
	By lLogin = By.xpath("//button[text()=' Login ']");
	
	
	//Method to enter user name & password:
	
	public void enterusername(String ousername) {
		driver.findElement(lusername).sendKeys(ousername);
	}
	
	public void enterpassword(String opassword) {
		driver.findElement(lpass).sendKeys(opassword);
	}
	
	public void clickLogin() {
		driver.findElement(lLogin).click();
	}
	
	
}
