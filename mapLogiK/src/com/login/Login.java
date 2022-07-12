package com.login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.login_pom.Login_pom;

public class Login {
	static WebDriver driver;
	
	public static void login() {
		driver=Login_baseclass.open_browser();
		PageFactory.initElements(driver, Login_pom.class);
		
		Login_pom.username.sendKeys("admin@gmail.com");
		Login_pom.password.sendKeys("Admin@123");
		Login_pom.submit.click();
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
		login();
		}
		catch(Exception e){
			Login_baseclass.takescreenshot();
		}

	}

}
