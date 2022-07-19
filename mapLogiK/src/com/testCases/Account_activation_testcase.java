package com.testCases;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Account_activation_objects;

public class Account_activation_testcase extends CommonFunctions {
	
	@Test
	public static void account_activation() throws IOException, InterruptedException {
		openBrowser_student();
	//	Student_login_testcases.login();
		PageFactory.initElements(driver, Account_activation_objects.class);
		String current_window=driver.getWindowHandle();
		
		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Account_activation_objects.activate_account)).click();
		
		scroll();
		Thread.sleep(1000);
		
		Account_activation_objects.pay_now.click();
		
		driver.switchTo().frame(0);
		scroll();
		
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Account_activation_objects.payment)).click();
		
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Account_activation_objects.icici)).click();
		
		wait.until(ExpectedConditions.visibilityOf(Account_activation_objects.pay)).click();
		
		Thread.sleep(2000);
		Set<String> windows=driver.getWindowHandles();
	   
		for(String new_window:windows) {
		if(!windows.equals(current_window)) {
		driver.switchTo().window(new_window);
		}
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Account_activation_objects.success)).click();
		
		Thread.sleep(1000);
		driver.switchTo().window(current_window);
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		screenshot();
		
	}

}
