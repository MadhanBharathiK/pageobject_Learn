package factoryLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hrDashBoard {
	
	WebDriver driver;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement DashboardIcon;
	
	@FindBy(xpath="//span[text()='My Info']")
	WebElement MyInfoMenu;
	
	
	
	
	public hrDashBoard(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public boolean isDashboardIconDisplayed() 
	{
		return DashboardIcon.isDisplayed();
	}
	
	public void clickMyInfoMenu()
	{
		MyInfoMenu.click();
	}
	
	
	
	
	
	
	
	
	
	}
	
	
	


