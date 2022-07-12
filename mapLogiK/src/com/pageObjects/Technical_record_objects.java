package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Technical_record_objects {
	
	@FindBy(xpath="//*[text()='Co Curricular Achievements']")
	public static WebElement co_curricular;

	@FindBy(xpath="//*[text()='Technical Record Creation']")
	public static WebElement technical_record;

	@FindBy(css="input[id='title']")
	public static WebElement title;

	@FindBy(css="select[name='which_field']")
	public static WebElement field;

	@FindBy(css="input[id='place']")
	public static WebElement place;

	@FindBy(css="input[name='year']")
	public static WebElement year;

	@FindBy(css="select[title='Select a year']")
	public static WebElement select_year;

	@FindBy(css="select[title='Select a month']")
	public static WebElement month;

	@FindBy(xpath="//*[text()='2'][1]")
	public static WebElement date;

	@FindBy(css="select[name='scope']")
	public static WebElement scope;

	@FindBy(css="select[name='award']")
	public static WebElement award;

	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit;
	
	@FindBy(xpath="//*[text()='Co Curricular Achievements']")
	public static WebElement co_curricular_adn;

	@FindBy(xpath="//*[text()='Technical Record Creation']")
	public static WebElement technical_record_adn;
	
	@FindBy(xpath=("//tbody/tr[1]/td[6]/a[1]"))
	public static WebElement pending;
	
	@FindBy(xpath="//*[@class='sidenav-overlay']/preceding::button[1]")
	public static WebElement approve;

}
