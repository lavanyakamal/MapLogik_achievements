package com.login_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_pom {
	@FindBy(id="login-email")
	public static WebElement username;
	@FindBy(id="login-password")
	public static WebElement password;
	@FindBy(xpath="//*[text()='Log in']")
	public static WebElement submit;

}
