package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Other_technical_activities_objects;
import com.pageObjects.Record_creation_objects;
import com.pageObjects.Sports_objects;

public class Record_creation_testcases extends CommonFunctions {
	
	@Test(priority=1)
	public static void record_creation() throws IOException, InterruptedException {
		openBrowser_student();
	//	Student_login_testcases.login();
		PageFactory.initElements(driver, Record_creation_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Record_creation_objects.extra_curricular)).click();

		wait.until(ExpectedConditions.elementToBeClickable(Record_creation_objects.record_creation)).click();
		
		record_creation_properties();
		wait.until(ExpectedConditions.visibilityOf(Record_creation_objects.title)).sendKeys(properties.getProperty("title"));

		wait.until(ExpectedConditions.visibilityOf(Record_creation_objects.place)).sendKeys(properties.getProperty("place"));

		wait.until(ExpectedConditions.visibilityOf(Record_creation_objects.date)).sendKeys(properties.getProperty("date"));
		
		wait.until(ExpectedConditions.visibilityOf(Record_creation_objects.scope));
		Select select_scope=select_class(Record_creation_objects.scope);
		select_scope.selectByVisibleText(properties.getProperty("scope"));

		wait.until(ExpectedConditions.visibilityOf(Record_creation_objects.submit)).click();

	}
	
	@Test(dependsOnMethods="record_creation")
	public static void record_creation_approval() throws IOException, InterruptedException {
		
		openBrowser_admin();
		Admin_login_testcases.admin_login();
		PageFactory.initElements(driver, Record_creation_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Record_creation_objects.extra_curricular_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Record_creation_objects.record_creation_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Record_creation_objects.pending)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Record_creation_objects.approve)).click();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="record_creation_approval")
	public static void takescreenshot() throws IOException, InterruptedException {
		openBrowser_student();
	//	Student_login_testcases.login();
		Thread.sleep(5000);
		screenshot();
	}

	@AfterMethod
	public static void closebrowser() {
		//driver.close();
	}

}
