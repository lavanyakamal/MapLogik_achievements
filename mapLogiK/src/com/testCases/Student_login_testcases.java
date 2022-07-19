package com.testCases;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseClass.CommonFunctions;
import com.pageObjects.Student_login_objects;

public class Student_login_testcases extends CommonFunctions {
	
	
/*	public static String[][] username_and_password() throws IOException{
		excel_username_extraction();
		excel_password_extraction();
		info=new String[username.size()][2];
		for(int i=0;i<username.size();i++) {
			System.out.println(info [i][0]=(String) username.get(i));
			System.out.println(info[i][1]=(String) password.get(i));
			
	  }
		return info;                                
	}
	
	@DataProvider(name="username_and_password")
	public String[][] data_provider() throws IOException{
		String[][] dp=username_and_password();
		return dp;
	}   */
	
//	@Test(dataProvider="username_and_password")
	@Test
	public static void login() throws IOException, InterruptedException {
	//	openBrowser_student();
		
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
	    
/*	    Thread.sleep(2000);
	    
	    Co_curricular_testcase.certificate();
	    
	    Co_curricular_testcase.admin_approval();
		
	}
	
	@AfterMethod
	public static void closebrowser() {
		driver.close();
	}   */

	}
}
