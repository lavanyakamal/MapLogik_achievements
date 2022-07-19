package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_profile_picture_objects {
	
	@FindBy(xpath="//*[text()='Profile']")
	public static WebElement profile;
	
	@FindBy(css="input[name='year']")
	public static WebElement year;

	@FindBy(css="input[name='alt_phone']")
	public static WebElement number;
	
	@FindBy(css="input[name='logo']")
	public static WebElement picture;
	
	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit;
	
	@FindBy(xpath="//*[text()='Dashboards']")
	public static WebElement dashboard;

}
