package Dropdown_DifferentApproch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class DropDown_Learn {

	
	
	//@BeforeClass
	public static void main(String args[]) { //static method  

		//System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525804791%7Cb%7Cfacebook%7C&placement=&creative=550525804791&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-592856129%26loc_physical_ms%3D9148884%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw1t2pBhAFEiwA_-A-NDVheaJQ8LzonZdUdlrvEqWoxR-VxOvwbHYZ93m9jJUKobSgiClSBhoCVeAQAvD_BwE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//locators for DOB:
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year= driver.findElement(By.id("year"));
		
	/*
		//locate select date:
		Select selectDay = new Select(day);
		selectDay.selectByVisibleText("5");
		
		//locate select month:
		Select selecMonth = new Select(month);
		selecMonth.selectByVisibleText("Jul");
		
		//locate year:
		Select selecYear = new Select(year);
		selecYear.selectByVisibleText("2020");   */
		
		
		String dob="5-Jul-2020";
		String dobArr[] = dob.split("-");
		
		/*
		selectFromDropDown(day,"5");
		selectFromDropDown(month,"Jul");
		selectFromDropDown(year,"2020");
		*/
		
		selectFromDropDown(day,dobArr[0]);
		selectFromDropDown(month,dobArr[1]);
		selectFromDropDown(year,dobArr[2]);
		
	}
	
	public static void selectFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	
}



	/*public static void SelectValueFromDropDown(WebElement element, String value) {
		
		Select select = new Select(element);
		select.deselectByVisibleText(value);
		
	}
*/

