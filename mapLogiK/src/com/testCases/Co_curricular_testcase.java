package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Admin_login_object;
import com.pageObjects.Co_curricular_objects;

public class Co_curricular_testcase extends CommonFunctions {
	
	@Test
	public static void certificate() throws IOException, InterruptedException {
		
		openBrowser_student();
		Student_login_testcases.login();
		PageFactory.initElements(driver, Co_curricular_objects.class);
		
		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Co_curricular_objects.co_curricular)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Co_curricular_objects.cerfificate)).click();
		
		certificate_properties();
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.title)).sendKeys(properties.getProperty("title"));
		
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.issuing)).sendKeys(properties.getProperty("issuing"));
		
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.board_name)).sendKeys(properties.getProperty("board_name"));
		
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.scope)).click();
		Select select=select_class(Co_curricular_objects.scope);
		select.selectByVisibleText(properties.getProperty("scope"));
		
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.year)).click();
		Thread.sleep(1000);
		scroll();
		
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.select_year)).click();
		Thread.sleep(1000);
		Select select_year=select_class(Co_curricular_objects.select_year);
		select_year.selectByVisibleText(properties.getProperty("year"));
		
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.select_month)).click();
		Thread.sleep(1000);
		Select select_month=select_class(Co_curricular_objects.select_month);
		select_month.selectByVisibleText(properties.getProperty("month"));
		
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.select_date)).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(Co_curricular_objects.submit)).click();
	}
	
	@Test(dependsOnMethods="certificate")
	public void admin_approval() throws InterruptedException, IOException {
		
		openBrowser_admin();
		Admin_login_testcases.admin_login();
		PageFactory.initElements(driver, Co_curricular_objects.class);
		
		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Co_curricular_objects.co_curricular_act)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Co_curricular_objects.certificate)).click();
		
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(Co_curricular_objects.pending)).click();
		
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(Co_curricular_objects.approve)).click();
		
	}

	@Test(dependsOnMethods="admin_approval")
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
