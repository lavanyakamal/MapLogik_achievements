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
import com.pageObjects.Sports_objects;

public class Sports_testcases extends CommonFunctions{
	
	@Test(priority=1)
	public static void sports() throws IOException, InterruptedException {
		openBrowser_student();
	//	Student_login_testcases.login();
		PageFactory.initElements(driver, Sports_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Sports_objects.extra_curricular)).click();

        wait.until(ExpectedConditions.elementToBeClickable(Sports_objects.sports)).click();
		
		sports_properties();
		wait.until(ExpectedConditions.visibilityOf(Sports_objects.event_name)).sendKeys(properties.getProperty("event_name"));
		
		wait.until(ExpectedConditions.visibilityOf(Sports_objects.conducted_by)).sendKeys(properties.getProperty("conducted_by"));

		wait.until(ExpectedConditions.visibilityOf(Sports_objects.date)).sendKeys(properties.getProperty("date"));
		
		wait.until(ExpectedConditions.visibilityOf(Sports_objects.level));
		Select select_level=select_class(Sports_objects.level);
		select_level.selectByVisibleText(properties.getProperty("level"));
		
		wait.until(ExpectedConditions.visibilityOf(Sports_objects.award));
		Select select_award=select_class(Sports_objects.award);
		select_award.selectByVisibleText(properties.getProperty("award"));
		
		wait.until(ExpectedConditions.visibilityOf(Sports_objects.submit)).click();

	}
	
	@Test(dependsOnMethods="sports")
	public static void sports_approval() throws IOException, InterruptedException {
		
		openBrowser_admin();
		Admin_login_testcases.admin_login();
		PageFactory.initElements(driver, Sports_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Sports_objects.extra_curricular_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Sports_objects.sports_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Sports_objects.pending)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Sports_objects.approve)).click();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="sports_approval")
	public static void takescreenshot() throws IOException, InterruptedException {
		openBrowser_student();
	//	Student_login_testcases.login();
		Thread.sleep(5000);
		screenshot();
	}

	@AfterMethod
	public static void closebrowser() {
		driver.close();
	}

}
