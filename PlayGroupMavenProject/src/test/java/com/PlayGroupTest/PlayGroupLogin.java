package com.PlayGroupTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlayGroupLogin {

	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\USER\\\\Desktop\\\\ChromeDriver jar\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.emeetify.com:81/playgroup/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority=1)
	public void verifyTile() {
		String ExcptedTitle = "Play Group :: Login";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(ExcptedTitle, actualtitle);
	}
	
	}
	
	
	

