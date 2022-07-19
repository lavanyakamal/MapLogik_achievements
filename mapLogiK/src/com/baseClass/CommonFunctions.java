package com.baseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class CommonFunctions {
	
    public static Properties properties=null;
	public static WebDriver driver;
	public static int row_no;
	public static File file=null;
	public static FileInputStream input=null;
	public static XSSFWorkbook workbook=null;
	public static XSSFSheet sheet=null;
	public static List username=new ArrayList();
	public static List password=new ArrayList();
	public static int index=0;
	public static FileWriter file_write=null;
//	public static String info[][]=null;
	
	public static WebDriverWait explicit_wait() {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	return wait;
	}
		
	public static void scroll() {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
	}
	
	public static void loadProperties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\config_maplogik.properties");
		properties=new Properties();
		properties.load(input);
		//return properties;
	}
	
	public static void certificate_properties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\certificate_config.properties");
		properties=new Properties();
		properties.load(input);
	}
	
	public static void product_solution_properties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\productSolution.properties");
		properties=new Properties();
		properties.load(input);
	}
	
	public static void symposium_properties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\symposium_config.properties");
		properties=new Properties();
		properties.load(input);
	}
	
	public static void technical_record_properties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\technical_record.properties");
		properties=new Properties();
		properties.load(input);
	}
	
	public static void other_technical_activities_properties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\other_technical_activities.properties");
		properties=new Properties();
		properties.load(input);
	}

	public static void sports_properties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\sports.properties");
		properties=new Properties();
		properties.load(input);
	}

	public static void record_creation_properties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\record_creation.properties");
		properties=new Properties();
		properties.load(input);
	}

	public static void culturals_properties() throws IOException {
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\mapLogiK\\src\\com\\baseClass\\culturals.properties");
		properties=new Properties();
		properties.load(input);
	}
	
	public static void add_profilePic_properties() throws IOException{
		FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\git\\MapLogik_achievements\\mapLogiK\\src\\com\\baseClass\\add_profilePicture.properties");
		properties=new Properties();
		properties.load(input);
	}
	
	public static Robot robot_class() throws AWTException {
		Robot robot=new Robot();
		return robot;
	}
	
	public static StringSelection stringSelection(String s) {
		StringSelection string=new StringSelection(s);
		return string;
	}

	public static Select select_class(WebElement element) {
		Select select=new Select(element);
		return select;
	}
	
	public static Actions action_class() {
		Actions action=new Actions(driver);
		return action;
	}
	
	public static FileWriter file_writer() throws IOException {
		loadProperties();
		String location=properties.getProperty("filewriter_location");
		file_write=new FileWriter(location);
		return file_write;
	}
	
	public static void openBrowser_admin() throws IOException {
		loadProperties();
		
		String driver_location=properties.getProperty("driver_location");
	//	String student_url=properties.getProperty("student_url");
		String admin_url=properties.getProperty("admin_url");
		
		System.setProperty("webdriver.chrome.driver", driver_location);
		driver=new ChromeDriver();
		driver.get(admin_url);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	public static void openBrowser_student() throws IOException {
		loadProperties();
		
		Scanner scan=new Scanner(System.in);
		System.out.println("enter index");
		index=scan.nextInt();   
		
		String driver_location=properties.getProperty("driver_location");
		String student_url=properties.getProperty("student_url");
	//	String admin_url=properties.getProperty("admin_url");
		
		System.setProperty("webdriver.chrome.driver", driver_location);
		driver=new ChromeDriver();
		driver.get(student_url);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	public static void excel_username_extraction() throws IOException {
		loadProperties();
	/*	index_s=properties.getProperty("student_index");
		index=Integer.parseInt(index_s);
		System.out.println(index);   */
		
		file=new File("D:\\MapLogiK\\trust college\\trust combined.xlsx");
		input=new FileInputStream(file);
		workbook=new XSSFWorkbook(input);
		sheet=workbook.getSheetAt(0);
		row_no=sheet.getLastRowNum();
	//	System.out.println(row_no);
		int column_no=sheet.getRow(0).getLastCellNum();
		List checker=new ArrayList();
		DataFormatter data=new DataFormatter();
		for(int i=0;i<=column_no;i++) {
			Cell cell_value=sheet.getRow(0).getCell(i);
			String cell_data=data.formatCellValue(cell_value);
			checker.add(cell_data);
		}
		
		int user_index=checker.indexOf("student_id");
		for(int i=1;i<=row_no;i++) {
		Cell cell_value=sheet.getRow(i).getCell(user_index);
		String student_id=data.formatCellValue(cell_value);
		username.add(student_id);
	//	System.out.println(student_id);
		}
	}
	
	public static void excel_password_extraction() throws IOException {
		loadProperties();
	/*	String index_s=properties.getProperty("student_index");
		index=Integer.parseInt(index_s);   */
		
		file=new File("D:\\MapLogiK\\trust college\\trust combined.xlsx");
		input=new FileInputStream(file);
		workbook=new XSSFWorkbook(input);
		sheet=workbook.getSheetAt(0);
		row_no=sheet.getLastRowNum();
		System.out.println(row_no);
		int column_no=sheet.getRow(0).getLastCellNum();
		List checker=new ArrayList();
		DataFormatter data=new DataFormatter();
		for(int i=0;i<=column_no;i++) {
			Cell cell_value=sheet.getRow(0).getCell(i);
			String cell_data=data.formatCellValue(cell_value);
			checker.add(cell_data);
		}
		
		int user_index=checker.indexOf("student_mobile");
		for(int i=1;i<=row_no;i++) {
		Cell cell_value=sheet.getRow(i).getCell(user_index);
		String student_mobile=data.formatCellValue(cell_value);
		password.add(student_mobile);
	//	System.out.println(student_mobile);
		}
	}
	
	public static void screenshot() throws IOException,InterruptedException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\MapLogiK\\trust college screenshots\\after profile picture\\"+username.get(index)+".png");
		FileHandler.copy(source,destination);
	}
	
/*	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}*/

}
