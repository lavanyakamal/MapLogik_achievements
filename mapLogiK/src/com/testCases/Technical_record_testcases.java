package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Symposium_objects;
import com.pageObjects.Technical_record_objects;

public class Technical_record_testcases extends CommonFunctions {
	
	@Test(priority=1)
	public static void technical_record() throws IOException, InterruptedException {
		openBrowser_student();
	//	Student_login_testcases.login();
		PageFactory.initElements(driver, Technical_record_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Technical_record_objects.co_curricular)).click();

		wait.until(ExpectedConditions.elementToBeClickable(Technical_record_objects.technical_record)).click();
		
		technical_record_properties();
		wait.until(ExpectedConditions.visibilityOf(Technical_record_objects.title)).sendKeys(properties.getProperty("title"));
		
		wait.until(ExpectedConditions.visibilityOf(Technical_record_objects.field)).click();
		Select select_field=select_class(Technical_record_objects.field);
		select_field.selectByVisibleText(properties.getProperty("field"));
		
		wait.until(ExpectedConditions.visibilityOf(Technical_record_objects.place)).sendKeys(properties.getProperty("place"));

		wait.until(ExpectedConditions.visibilityOf(Technical_record_objects.year)).click();
		scroll();
		Thread.sleep(1000);

		Select select_year=select_class(Technical_record_objects.select_year);
		select_year.selectByVisibleText(properties.getProperty("year"));

		Select select_month=select_class(Technical_record_objects.month);
		select_month.selectByVisibleText(properties.getProperty("month"));
		
		wait.until(ExpectedConditions.visibilityOf(Technical_record_objects.date)).click();

		wait.until(ExpectedConditions.visibilityOf(Technical_record_objects.scope)).click();
		Select select_scope=select_class(Technical_record_objects.scope);
		select_scope.selectByVisibleText(properties.getProperty("scope"));
		
		wait.until(ExpectedConditions.visibilityOf(Technical_record_objects.award)).click();
		Select select_award=select_class(Technical_record_objects.award);
		select_award.selectByVisibleText(properties.getProperty("award"));

		scroll();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(Technical_record_objects.submit)).click();
	}
	
	@Test(dependsOnMethods="technical_record")
	public static void technical_record_approval() throws IOException, InterruptedException {
		
		openBrowser_admin();
		Admin_login_testcases.admin_login();
		PageFactory.initElements(driver, Technical_record_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Technical_record_objects.co_curricular_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Technical_record_objects.technical_record_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Technical_record_objects.pending)).click();
		
		scroll();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(Technical_record_objects.approve)).click();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="technical_record_approval")
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
