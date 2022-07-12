package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Other_technical_activities_objects {
	
	@FindBy(xpath="//*[text()='Co Curricular Achievements']")
	public static WebElement co_curricular;

	@FindBy(xpath="//*[text()='Other Technical Activities']")
	public static WebElement other_technical_activities;

	@FindBy(css="input[id='title']")
	public static WebElement title;

	@FindBy(css="input[id='conducted_by']")
	public static WebElement conducted_by;

	@FindBy(css="input[id='place']")
	public static WebElement place;

	@FindBy(css="input[name='year']")
	public static WebElement year;

	@FindBy(css="select[title='Select a year']")
	public static WebElement select_year;

	@FindBy(css="select[title='Select a month']")
	public static WebElement month;

	@FindBy(xpath="//*[text()='8']")
	public static WebElement date;

	@FindBy(css="select[name='award']")
	public static WebElement award;

	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit;

	@FindBy(xpath="//*[text()='Co Curricular Achievements']")
	public static WebElement co_curricular_adn;

	@FindBy(xpath="//*[text()='Other Technical Activities']")
	public static WebElement other_technical_activities_adn;

	@FindBy(xpath=("//tbody/tr[1]/td[6]/a[1]"))
	public static WebElement pending;
	
	@FindBy(xpath="//*[@class='sidenav-overlay']/preceding::button[1]")
	public static WebElement approve;

}
