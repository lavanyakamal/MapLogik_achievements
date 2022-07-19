package com.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Add_profile_picture_objects;
import com.pageObjects.Product_solution_objects;

public class Add_profile_picture_testcase extends CommonFunctions {
	
	@Test(priority=1)
	public static void add_profilePicture() throws IOException, AWTException, InterruptedException {
		
		openBrowser_student();
		Student_login_testcases.login();
		PageFactory.initElements(driver, Add_profile_picture_objects.class);
		add_profilePic_properties();
		
		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Add_profile_picture_objects.profile)).click();
		
		wait.until(ExpectedConditions.visibilityOf(Add_profile_picture_objects.year)).sendKeys(properties.getProperty("year"));
		
		wait.until(ExpectedConditions.visibilityOf(Add_profile_picture_objects.number)).sendKeys(properties.getProperty("number"));
		
		Actions action=action_class();
		action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(Add_profile_picture_objects.picture))).click().build().perform();
		
		StringSelection string=stringSelection(properties.getProperty("picture"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		
		Robot robot=robot_class();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(Add_profile_picture_objects.submit)).click();
	}
	
	@Test(dependsOnMethods="add_profilePicture")
	public static void check_dashboard() throws IOException, InterruptedException {
		WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Add_profile_picture_objects.dashboard)).click();
		
		screenshot();
	}
	
	@AfterTest
	public static void closebrowser() {
		driver.close();
	}

}
