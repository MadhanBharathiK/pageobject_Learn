package ExtentReportTypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;

public class ReportExet {
	
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

	
	
	@BeforeClass
	public void setfile() {
		
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\Users\\USER\\Desktop\\testout\\testreport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");  }

        @Test
        public void set() {
        	
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\USER\\\\Desktop\\\\ChromeDriver jar\\\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		driver.get("https://demo.emeetify.com:81/playgroup/admin/login");
		
	}
	
	

}
