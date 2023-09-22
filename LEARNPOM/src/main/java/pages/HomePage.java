package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	// Locator for Dashboard:
	By DashboardLogo = By.xpath("//h6[text()='Dashboard']");
	
	By lClickMyInfo = By.xpath("//span[text()='My Info']");
	
	
	
	
	
	
	
	
	//Method to check Dashboard:
	public boolean isDashboardDisplayed() {
	return	driver.findElement(DashboardLogo).isDisplayed();
		
	}
	
	//Metho to check ClickMyInfo:
	public void clickMyInfoOnDashboard() {
	
		driver.findElement(lClickMyInfo).click();
		
	}
				
	}

