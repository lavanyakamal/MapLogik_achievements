package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Record_creation_objects {
	
	@FindBy(xpath="//*[text()='Extra Curricular Activities']")
	public static WebElement extra_curricular;

	@FindBy(xpath="//*[text()='Record Creation']")
	public static WebElement record_creation;

	@FindBy(css="input[id='title']")
	public static WebElement title;

	@FindBy(css="input[id='conducted_by']")
	public static WebElement place;

	@FindBy(css="input[name='year']")
	public static WebElement date;

	@FindBy(css="select[name='award']")
	public static WebElement scope;

	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit;

	@FindBy(xpath="//*[text()='Extra Curricular Activities']")
	public static WebElement extra_curricular_adn;

	@FindBy(xpath="//*[text()='Record Creation']")
	public static WebElement record_creation_adn;

	@FindBy(xpath=("//tbody/tr[1]/td[6]/a[1]"))
	public static WebElement pending;
	
	@FindBy(xpath="//*[@class='sidenav-overlay']/preceding::button[1]")
	public static WebElement approve;

}
