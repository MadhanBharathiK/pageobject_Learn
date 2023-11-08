package ExtentReportTypes;

import java.time.Duration;

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
	WebDriver driver;

	
	
	@BeforeClass
	public void setfile() {
		
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\Users\\USER\\Desktop\\testout\\testreport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Reporter");
        htmlReporter.config().setReportName("Test Reporter");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"); 
        }

        @Test
        public void setup() {
    		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver-win32\\chromedriver.exe");

    		
    		driver=new ChromeDriver();
    		driver.get("http://localhost:4200/auth/login");
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    		System.out.println("Browser Launched");
    		
    	}
		
		
	}
	
	


