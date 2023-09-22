  package com.Base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	protected static WebDriver driver;
	static Properties prop;
	
	
	public TestBase() throws IOException {
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\PAGEOBJECT\\src\\main\\java\\com\\Configure\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		 if(browserName.equals("chrome")) {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\ChromeDriver jar\\chromedriver.exe");
	 driver=new ChromeDriver();
	 }
		 else {
			 System.out.println("Browser not found");
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		 driver.get(prop.getProperty("url"));
	}
}
