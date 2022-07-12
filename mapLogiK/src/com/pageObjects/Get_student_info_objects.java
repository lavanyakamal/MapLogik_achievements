package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Get_student_info_objects {
	
	@FindBy(xpath="//div[@class='col-md-2 text-center']/preceding::b[1]")
	public static WebElement student_name;

	@FindBy(xpath="//div[@class='student-info mb-0']/child::p[1]")
	public static WebElement college;

	@FindBy(xpath="//div[@class='student-info mb-0']/child::p[2]")
	public static WebElement department;
	
	///html/body/div[3]/div[3]/div/section/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/p[3]/text()
	@FindBy(xpath="//div[@class='student-info mb-0']/child::p[3]/b")
	public static WebElement district;

	@FindBy(xpath="//div[@class='student-ranking text-right']/child::span[1]")
	public static WebElement rank;

	@FindBy(xpath="//div[@class='row item']/following::span[1]")
	public static WebElement skill;

	@FindBy(xpath="//div[@class='row item']/following::span[3]")
	public static WebElement achievement;

	@FindBy(xpath="//div[@class='row item']/following::span[5]")
	public static WebElement academics;
	
	///html/body/div[3]/div[3]/div/section/div[1]/div[1]/div/div[2]/div/div[2]/p/text()[1]
	@FindBy(xpath="//div[@class='item-description']/child::p/b")
	public static WebElement unicorn_of_district;

	///html/body/div[3]/div[3]/div/section/div[1]/div[3]/div/div[2]/div/div[2]/p/text()[1]
	@FindBy(xpath="//div[@class='item-description']/following::p[2]/b")
	public static WebElement unicorn_of_state;


}
