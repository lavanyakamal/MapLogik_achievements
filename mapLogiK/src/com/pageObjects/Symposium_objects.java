package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Symposium_objects {
	
	@FindBy(xpath="//*[text()='Co Curricular Achievements']")
	public static WebElement co_curricular;

	@FindBy(xpath="//*[text()='Symposium']")
	public static WebElement symposium;

	@FindBy(css="input[id='title']")
	public static WebElement title;

	@FindBy(css="select[name='category']")
	public static WebElement category;

	@FindBy(css="input[id='conducted_by']")
	public static WebElement conducted_by;

	@FindBy(css="input[name='year']")
	public static WebElement year;

	@FindBy(css="select[title='Select a year']")
	public static WebElement year_select;

	@FindBy(css="select[title='Select a month']")
	public static WebElement month;

	@FindBy(xpath="//*[text()='11']")
	public static WebElement date;

	@FindBy(css="select[name='level']")
	public static WebElement level;

	@FindBy(css="select[name='award']")
	public static WebElement award;

	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit;

	@FindBy(xpath="//*[text()='Co Curricular Achievements']")
	public static WebElement co_curricular_adn;

	@FindBy(xpath="//*[text()='Symposium']")
	public static WebElement symposium_adn;

	@FindBy(xpath=("//tbody/tr[1]/td[6]/a[1]"))
	public static WebElement pending;
	
	@FindBy(xpath="//*[@class='sidenav-overlay']/preceding::button[1]")
	public static WebElement approve;


}
