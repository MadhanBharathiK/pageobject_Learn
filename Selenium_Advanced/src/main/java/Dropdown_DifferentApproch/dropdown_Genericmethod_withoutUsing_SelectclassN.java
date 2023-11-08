package Dropdown_DifferentApproch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown_Genericmethod_withoutUsing_SelectclassN {

	static WebDriver driver;
	
	public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		
	    driver=new ChromeDriver();
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525804791%7Cb%7Cfacebook%7C&placement=&creative=550525804791&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-592856129%26loc_physical_ms%3D9148884%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw1t2pBhAFEiwA_-A-NDVheaJQ8LzonZdUdlrvEqWoxR-VxOvwbHYZ93m9jJUKobSgiClSBhoCVeAQAvD_BwE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String dayXpath ="//select[@id='day']//option";
		String monthXpath ="//select[@id='month']//option";
		String yearXpath ="//select[@id='year']//option";
		
		SelectDropdownValues(dayXpath,"7");
		SelectDropdownValues(monthXpath,"Jul");
		SelectDropdownValues(yearXpath,"1998");

	}

		
		public static void SelectDropdownValues(String xpathValue, String values ) {
			List<WebElement> dayList=driver.findElements(By.xpath(xpathValue));
			System.out.println(dayList.size());
			
			//To print all days using loop:
			for(int i=0;i<dayList.size();i++) {
				System.out.println(dayList.get(i).getText());
				
				//Select day 7 using if:
				if(dayList.get(i).getText().equals(values)) {
					
					dayList.get(i).click();
					break;
					
				}
			}
			
		}
	}


