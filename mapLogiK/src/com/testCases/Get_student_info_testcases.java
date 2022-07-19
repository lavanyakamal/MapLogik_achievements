package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Culturals_objects;
import com.pageObjects.Get_student_info_objects;

public class Get_student_info_testcases extends CommonFunctions {
	
	@Test
	public static void student_info() throws IOException, InterruptedException {
		
		openBrowser_student();
		Student_login_testcases.login();
		PageFactory.initElements(driver, Get_student_info_objects.class);
		
		file_writer();

		WebDriverWait wait=explicit_wait();
		String student_name=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.student_name)).getText();
		file_write.write("student_name:"+student_name+'\n');
		
		String college=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.college)).getText();
		file_write.write("college:"+college+'\n');
		
		String department=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.department)).getText();
		file_write.write("department:"+department+'\n');
		
		String district=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.district)).getAttribute("innerhtml");
		file_write.write("district:"+district+'\n');
		
		String rank=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.rank)).getText();
		file_write.write("rank:"+rank+'\n');
		
		String skill=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.skill)).getText();
		file_write.write("skill:"+skill+'\n');
		
		String achievement=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.achievement)).getText();
		file_write.write("achievement:"+achievement+'\n');
		
		String academics=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.academics)).getText();
		file_write.write("academics:"+academics+'\n');
		
		String district_unicorn=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.unicorn_of_district)).getAttribute("innerhtml");
		file_write.write("district_unicorn:"+district_unicorn+'\n');
		
		String state_unicorn=wait.until(ExpectedConditions.visibilityOf(Get_student_info_objects.unicorn_of_state)).getAttribute("innerhtml");
		file_write.write("state_unicorn:"+state_unicorn);
		
		file_write.close();
	}
	
	@AfterMethod
	public static void closebrowser() {
	//	driver.close();
	}

}
