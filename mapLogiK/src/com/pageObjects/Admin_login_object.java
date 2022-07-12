package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Admin_login_object {
	
	@FindBy(id="login-email")
	public static WebElement username;
	
	@FindBy(id="login-password")
	public static WebElement password;
	
	@FindBy(xpath="//*[text()='Log in']")
	public static WebElement submit;

}
