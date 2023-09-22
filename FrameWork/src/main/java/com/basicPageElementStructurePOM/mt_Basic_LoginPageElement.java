package com.basicPageElementStructurePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mt_Basic_LoginPageElement {

	public static WebElement findUsername(WebDriver driver) {
	return driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
	}
	
	public static WebElement findPassword(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		
	}
	
	public static WebElement clickingLoginBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Login']"));
	
		
	}
	
	
}
