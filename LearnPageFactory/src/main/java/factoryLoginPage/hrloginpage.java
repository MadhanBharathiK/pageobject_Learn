package factoryLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hrloginpage {

	
	WebDriver driver;
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement LoginBtn;
	
   public hrloginpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
   	
   public void EnterUserName(String uname) {
	   username.sendKeys(uname);
   }
	
   public void EnterUserPassword(String upass) {
	   password.sendKeys(upass);
   }
   
   public void ClickLoginBtn() {
	   LoginBtn.click();
	   
   }
	
	
}
