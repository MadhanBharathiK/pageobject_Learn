package hr_PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class hr_Login {
	
	WebDriver driver;
	
	By username =By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By login = By.xpath("//button[text()=' Login ']");
	
	public hr_Login(WebDriver driver) {
		this.driver=driver;
		}
	
	public void typeUsername() {
		driver.findElement(username).sendKeys("Admin");
	}
	
	public void typePassword() {
		driver.findElement(password).sendKeys("admin123");
	}
	
	public void clickLogin() {
		driver.findElement(login).click();
	}

}
