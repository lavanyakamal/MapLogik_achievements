package com.college_activation_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class College_activation_pom {
	
	@FindBy(id="login-email")
	public static WebElement username;
	
	@FindBy(id="login-password")
	public static WebElement password;
	
	@FindBy(xpath="//*[text()='Log in']")
	public static WebElement submit;
	
	@FindBy(xpath="//*[text()='College Activation']")
	public static WebElement college_activate;
	
	@FindBy(xpath="//*[@href='http://maplogik.com/index.php/admin/college/addCollege']")
	public static WebElement add_button;
	
	@FindBy(id="course_name")
	public static WebElement college_name;
	
	@FindBy(name="logo")
	public static WebElement logo;
	
	@FindBy(id="address")
	public static WebElement address;
	
	@FindBy(id="location")
	public static WebElement location;
	
	@FindBy(name="affliation")
	public static WebElement affliation;
	
	@FindBy(name="affliated_to")
	public static WebElement affliated_to;
	
	@FindBy(name="college_type")
	public static WebElement college_type;
	
	@FindBy(xpath="//select[@id='bootstrap-duallistbox-nonselected-list_course[]']/preceding::div[1]")
	public static WebElement professional_ug;
	
	@FindBy(xpath="//select[@id='bootstrap-duallistbox-nonselected-list_course1[]']/preceding::div[1]")
	public static WebElement professional_pg;
	
	@FindBy(xpath="//select[@id='bootstrap-duallistbox-nonselected-list_course2[]']/preceding::div[1]")
	public static WebElement polytechnic;
	
	@FindBy(id="cnt_name")
	public static WebElement contact_name;
	
	@FindBy(id="cnt_number")
	public static WebElement contact_number;
	
	@FindBy(id="cnt_email")
	public static WebElement email;
	
	@FindBy(id="cnt_name_plc")
	public static WebElement contact_name_placement;
	
	@FindBy(id="cnt_number_plc")
	public static WebElement contact_number_placement;
	
	@FindBy(id="course_email_plc")
	public static WebElement email_placement;
	
	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit_button;
	
	@FindBy(xpath="//*[@href='http://maplogik.com/index.php/admin/college/addCollege']")
	public static WebElement add_2;

}
