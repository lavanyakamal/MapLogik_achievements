package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sports_objects {
	
	@FindBy(xpath="//*[text()='Extra Curricular Activities']")
	public static WebElement extra_curricular;

	@FindBy(xpath="//*[text()='Sports']")
	public static WebElement sports;

	@FindBy(css="input[id='title']")
	public static WebElement event_name;

	@FindBy(css="input[id='conducted_by']")
	public static WebElement conducted_by;

	@FindBy(css="input[name='year']")
	public static WebElement date;

	@FindBy(css="select[name='award']")
	public static WebElement award;

	@FindBy(css="select[name='level']")
	public static WebElement level;

	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit;

	@FindBy(xpath="//*[text()='Extra Curricular Activities']")
	public static WebElement extra_curricular_adn;

	@FindBy(xpath="//*[text()='Sports']")
	public static WebElement sports_adn;

	@FindBy(xpath=("//tbody/tr[1]/td[7]/a[1]"))
	public static WebElement pending;
	
	@FindBy(xpath="//*[@class='sidenav-overlay']/preceding::button[1]")
	public static WebElement approve;

}
