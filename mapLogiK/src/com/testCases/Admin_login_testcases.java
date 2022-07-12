package com.testCases;

import org.openqa.selenium.support.PageFactory;

import com.baseClass.CommonFunctions;
import com.pageObjects.Admin_login_object;

public class Admin_login_testcases extends CommonFunctions {
	
public static void admin_login() {
		
		PageFactory.initElements(driver, Admin_login_object.class);
		Admin_login_object.username.sendKeys("admin@gmail.com");
		Admin_login_object.password.sendKeys("Admin@123");
		Admin_login_object.submit.click();
		
	}
	

}
