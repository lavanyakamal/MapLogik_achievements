package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Culturals_objects;
import com.pageObjects.Record_creation_objects;

public class Culturals_testcases extends CommonFunctions {
	
	@Test(priority=1)
	public static void culturals() throws IOException, InterruptedException {
		openBrowser_student();
		Student_login_testcases.login();
		PageFactory.initElements(driver, Culturals_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Culturals_objects.extra_curricular)).click();

		wait.until(ExpectedConditions.elementToBeClickable(Culturals_objects.culturals)).click();
		
		culturals_properties();
		wait.until(ExpectedConditions.visibilityOf(Culturals_objects.location)).sendKeys(properties.getProperty("location"));

		wait.until(ExpectedConditions.visibilityOf(Culturals_objects.conducted_by)).sendKeys(properties.getProperty("conducted_by"));

		wait.until(ExpectedConditions.visibilityOf(Culturals_objects.date)).sendKeys(properties.getProperty("date"));
		
		wait.until(ExpectedConditions.visibilityOf(Culturals_objects.award));
		Select select_award=select_class(Culturals_objects.award);
		select_award.selectByVisibleText(properties.getProperty("award"));

		wait.until(ExpectedConditions.visibilityOf(Culturals_objects.submit)).click();

	}
	
	@Test(dependsOnMethods="culturals")
	public static void culturals_approval() throws IOException, InterruptedException {
		
		openBrowser_admin();
		Admin_login_testcases.admin_login();
		PageFactory.initElements(driver, Culturals_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Culturals_objects.extra_curricular_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Culturals_objects.culturals_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Culturals_objects.pending)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Culturals_objects.approve)).click();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="culturals_approval")
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
