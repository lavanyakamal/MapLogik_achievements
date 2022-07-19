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
import com.pageObjects.Technical_record_objects;

public class Other_technical_activities_testcases extends CommonFunctions {
	
	@Test(priority=1)
	public static void other_technical_activities() throws IOException, InterruptedException {
		openBrowser_student();
		Student_login_testcases.login();
		PageFactory.initElements(driver, Other_technical_activities_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Other_technical_activities_objects.co_curricular)).click();

		wait.until(ExpectedConditions.elementToBeClickable(Other_technical_activities_objects.other_technical_activities)).click();
		
		other_technical_activities_properties();
		wait.until(ExpectedConditions.visibilityOf(Other_technical_activities_objects.title)).sendKeys(properties.getProperty("title"));
		
		wait.until(ExpectedConditions.visibilityOf(Other_technical_activities_objects.conducted_by)).sendKeys(properties.getProperty("conducted_by"));
		
		wait.until(ExpectedConditions.visibilityOf(Other_technical_activities_objects.place)).sendKeys(properties.getProperty("location"));
		
		wait.until(ExpectedConditions.visibilityOf(Other_technical_activities_objects.year)).click();
		scroll();
		Thread.sleep(1000);

		Select select_year=select_class(Other_technical_activities_objects.select_year);
		select_year.selectByVisibleText(properties.getProperty("year"));

		Select select_month=select_class(Other_technical_activities_objects.month);
		select_month.selectByVisibleText(properties.getProperty("month"));
		
		wait.until(ExpectedConditions.visibilityOf(Other_technical_activities_objects.date)).click();
		
	//	wait.until(ExpectedConditions.visibilityOf(Other_technical_activities_objects.award)).click();
		Select select_award=select_class(Other_technical_activities_objects.award);
		select_award.selectByVisibleText(properties.getProperty("award"));
		
		wait.until(ExpectedConditions.visibilityOf(Other_technical_activities_objects.submit)).click();

	}
	
	@Test(dependsOnMethods="other_technical_activities")
	public static void technical_record_approval() throws IOException, InterruptedException {
		
		openBrowser_admin();
		Admin_login_testcases.admin_login();
		PageFactory.initElements(driver, Other_technical_activities_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Other_technical_activities_objects.co_curricular_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Other_technical_activities_objects.other_technical_activities_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Other_technical_activities_objects.pending)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Other_technical_activities_objects.approve)).click();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="technical_record_approval")
	public static void takescreenshot() throws IOException, InterruptedException {
		openBrowser_student();
		Student_login_testcases.login();
		Thread.sleep(5000);
		screenshot();
	}

	@AfterMethod
	public static void closebrowser() {
		driver.close();
	}

}
