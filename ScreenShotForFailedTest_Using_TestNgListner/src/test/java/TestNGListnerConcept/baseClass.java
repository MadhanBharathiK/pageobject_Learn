package TestNGListnerConcept;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

public class baseClass {
	
	public static WebDriver driver;
	
	public static void initialization() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://ec2-3-109-146-207.ap-south-1.compute.amazonaws.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	public void failed(String testMethodName) {
	
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFileToDirectory(scrFile, new File("C:\\Users\\USER\\eclipse-workspace\\ScreenShotForFailedTest_Using_TestNgListner\\screenshots"+testMethodName+"_"+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public void onTestStart(ITestResult reuslt) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult reuslt) {
		// TODO Auto-generated method stub
		
		
		
	}

	public void onTestSuccess(ITestResult reuslt) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult reuslt) {
		// TODO Auto-generated method stub
		
	}
	
	
}
