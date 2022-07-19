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
import com.pageObjects.Product_solution_objects;

public class Product_solution_testcase extends CommonFunctions {
	
	@Test(priority=1)
	public static void product_solution() throws IOException, InterruptedException {
		
		openBrowser_student();
		Student_login_testcases.login();
		PageFactory.initElements(driver, Product_solution_objects.class);
		
		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Product_solution_objects.co_curricular)).click();

		wait.until(ExpectedConditions.elementToBeClickable(Product_solution_objects.product_solution)).click();
		
		product_solution_properties();
		wait.until(ExpectedConditions.visibilityOf(Product_solution_objects.title)).sendKeys(properties.getProperty("title"));
		
		wait.until(ExpectedConditions.visibilityOf(Product_solution_objects.industry)).click();
		
		Select select=select_class(Product_solution_objects.industry);
		select.selectByVisibleText(properties.getProperty("industry"));
		
		wait.until(ExpectedConditions.visibilityOf(Product_solution_objects.purpose)).sendKeys(properties.getProperty("purpose"));
		
		wait.until(ExpectedConditions.visibilityOf(Product_solution_objects.year)).click();
		scroll();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(Product_solution_objects.select_year)).click();
		Select select_year=select_class(Product_solution_objects.select_year);
		select_year.selectByVisibleText(properties.getProperty("year"));
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(Product_solution_objects.month)).click();
		Select select_month=select_class(Product_solution_objects.month);
		select_month.selectByVisibleText(properties.getProperty("month"));
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(Product_solution_objects.date)).click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(Product_solution_objects.submit)).click();
	}
	
	@Test(dependsOnMethods="product_solution")
	public static void product_solution_approval() throws IOException  {
		
		openBrowser_admin();
		Admin_login_testcases.admin_login();
		PageFactory.initElements(driver, Product_solution_objects.class);
			
			WebDriverWait wait=explicit_wait();
			wait.until(ExpectedConditions.elementToBeClickable(Product_solution_objects.co_curricular_adn)).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(Product_solution_objects.product_solution_adn)).click();
			
			//Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(Product_solution_objects.pending)).click();
			
			//Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(Product_solution_objects.approve)).click();
		
	}
	
	@Test(dependsOnMethods="product_solution_approval")
	public static void takescreenshot() throws IOException, InterruptedException {
		openBrowser_student();
		Student_login_testcases.login();
		Thread.sleep(3000);
		screenshot();
	}

	@AfterMethod
	public static void closebrowser() {
		driver.close();
	}
	
	
}
