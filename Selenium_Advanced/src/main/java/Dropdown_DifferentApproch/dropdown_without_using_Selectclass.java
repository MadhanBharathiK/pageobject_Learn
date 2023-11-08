package Dropdown_DifferentApproch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown_without_using_Selectclass {

	public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525804791%7Cb%7Cfacebook%7C&placement=&creative=550525804791&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-592856129%26loc_physical_ms%3D9148884%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw1t2pBhAFEiwA_-A-NDVheaJQ8LzonZdUdlrvEqWoxR-VxOvwbHYZ93m9jJUKobSgiClSBhoCVeAQAvD_BwE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//We can use driver.findelements behalf of select class:
		
		List<WebElement> monthdrop=driver.findElements(By.xpath("//select[@id='month']//option"));
		System.out.println(monthdrop.size());
		
		System.out.println("*****************************");
		for(int i=0;i<monthdrop.size();i++) {
			System.out.println(monthdrop.get(i).getText());
			
			if(monthdrop.get(i).getText().equals("Jul")) {
			monthdrop.get(i).click();
			break;
			
		}
	
	}

}}
