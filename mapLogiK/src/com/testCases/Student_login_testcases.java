package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Student_login_objects;

public class Student_login_testcases extends CommonFunctions {
	
	@Test
	public static void login() throws IOException {
		PageFactory.initElements(driver, Student_login_objects.class);
		excel_username_extraction();
	    String student_username=(String) username.get(index);
	    
	    Student_login_objects.studentid.sendKeys(student_username);
	    
	    excel_password_extraction();
	    String student_password=(String) password.get(index);
	    
	    Student_login_objects.password.sendKeys(student_password);
	    
	    Student_login_objects.log_in.click();
	    
	    WebDriverWait wait=explicit_wait();
	    String otp=wait.until(ExpectedConditions.visibilityOf(Student_login_objects.otp_read)).getText();
	    //System.out.print("otp"+otp);
	    
	    Student_login_objects.otp_write.sendKeys(otp);
	    
	    Student_login_objects.submit.click();
		
	}
	

}
