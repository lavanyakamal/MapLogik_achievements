package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Product_solution_objects;
import com.pageObjects.Symposium_objects;

public class Symposium_testcases extends CommonFunctions {
	
	@Test(priority=1)
	public static void symposium() throws IOException, InterruptedException {
		openBrowser_student();
		Student_login_testcases.login();
		PageFactory.initElements(driver, Symposium_objects.class);
		
		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Symposium_objects.co_curricular)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Symposium_objects.symposium)).click();

		symposium_properties();
		wait.until(ExpectedConditions.visibilityOf(Symposium_objects.title)).sendKeys(properties.getProperty("title"));

		wait.until(ExpectedConditions.visibilityOf(Symposium_objects.category)).click();
		Select select_category=select_class(Symposium_objects.category);
		select_category.selectByVisibleText(properties.getProperty("category"));

		wait.until(ExpectedConditions.visibilityOf(Symposium_objects.conducted_by)).sendKeys(properties.getProperty("conducted_by"));
		
		wait.until(ExpectedConditions.visibilityOf(Symposium_objects.year)).click();
		scroll();
		Thread.sleep(1000);

		Select select_year=select_class(Symposium_objects.year_select);
		select_year.selectByVisibleText(properties.getProperty("year"));

		Select select_month=select_class(Symposium_objects.month);
		select_month.selectByVisibleText(properties.getProperty("month"));

		wait.until(ExpectedConditions.visibilityOf(Symposium_objects.date)).click();
		
		wait.until(ExpectedConditions.visibilityOf(Symposium_objects.level)).click();
		Select select_level=select_class(Symposium_objects.level);
		select_level.selectByVisibleText(properties.getProperty("level"));
		
		wait.until(ExpectedConditions.visibilityOf(Symposium_objects.award)).click();
		Select select_award=select_class(Symposium_objects.award);
		select_award.selectByVisibleText(properties.getProperty("award"));

		wait.until(ExpectedConditions.visibilityOf(Symposium_objects.submit)).click();

	}
	
	@Test(dependsOnMethods="symposium")
	public static void symposium_approval() throws IOException {
		openBrowser_admin();
		Admin_login_testcases.admin_login();
		PageFactory.initElements(driver, Symposium_objects.class);

		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Symposium_objects.co_curricular_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Symposium_objects.symposium_adn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Symposium_objects.pending)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Symposium_objects.approve)).click();

	}
	
	@Test(dependsOnMethods="symposium_approval")
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
