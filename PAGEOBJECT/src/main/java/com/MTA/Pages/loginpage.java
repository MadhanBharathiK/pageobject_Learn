package com.MTA.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

public class loginpage extends TestBase {

	/*public loginpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	*/
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-auth[1]/app-login[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/input[1]")
	WebElement username;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-auth[1]/app-login[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/input[1]")
	WebElement password;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-auth[1]/app-login[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
	WebElement LoginBtn;
	
	public loginpage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
		
	}
	
	
	}  
	
	

