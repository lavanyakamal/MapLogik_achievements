package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product_solution_objects {
	
	@FindBy(xpath="//*[text()='Co Curricular Achievements']")
	public static WebElement co_curricular;
	
	@FindBy(xpath="//*[text()='Product / Solution Development']")
	public static WebElement product_solution;

	@FindBy(xpath="//*[@id='title']")
	public static WebElement title;

	@FindBy(name="industry")//select
	public static WebElement industry;

	@FindBy(name="purpose")
	public static WebElement purpose;

	@FindBy(name="year")
	public static WebElement year;

	@FindBy(xpath="//*[@title='Select a year']")//select
	public static WebElement select_year;

	@FindBy(xpath="//*[@title='Select a month']")//select
	public static WebElement month;
	
	@FindBy(xpath="//*[text()='2'][1]")
	public static WebElement date;

	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit;
	
	@FindBy(xpath="//*[text()='Co Curricular Achievements']")
	public static WebElement co_curricular_adn;
	
	@FindBy(xpath="//*[text()='Product / Solution Development']")
	public static WebElement product_solution_adn;
	
	@FindBy(xpath=("//tbody/tr[1]/td[5]/a[1]"))
	public static WebElement pending;
	
	@FindBy(xpath="//*[@class='sidenav-overlay']/preceding::button[1]")
	public static WebElement approve;

}
