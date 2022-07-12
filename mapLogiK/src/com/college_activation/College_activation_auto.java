package com.college_activation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.college_activation_pom.College_activation_pom;

public class College_activation_auto {
	
	static WebDriver driver;
	
	public static void activation() throws IOException, InterruptedException, AWTException {
		driver=College_activation_baseclass.open_browser();
		PageFactory.initElements(driver, College_activation_pom.class);
		College_activation_pom.username.sendKeys("admin@gmail.com");
		College_activation_pom.password.sendKeys("Admin@123");
		College_activation_pom.submit.click();
		
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		wait1.until(ExpectedConditions.elementToBeClickable(College_activation_pom.college_activate)).click();
		
		
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		wait2.until(ExpectedConditions.elementToBeClickable(College_activation_pom.add_button)).click();
		
		
		File file=new File("D:\\MapLogiK\\college_activation my.xlsx");
		FileInputStream input=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheet("sheet2");
		int row_no=sheet.getLastRowNum();
		System.out.println(row_no);
		int column_no=sheet.getRow(0).getLastCellNum();
		System.out.println(column_no);
		List<String> data=new ArrayList<String>();
		
		for(int i=4;i<5;i++) {
		for(int j=0;j<column_no;j++) {
			Cell cell=sheet.getRow(i).getCell(j);
			DataFormatter new_data=new DataFormatter();
			String info=new_data.formatCellValue(cell);
			data.add(info);
		}
		
		int list_size=data.size();
		for(int k=0;k<list_size;k++) {
			System.out.println(data.get(k));
		}
		WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		wait3.until(ExpectedConditions.visibilityOf(College_activation_pom.college_name)).sendKeys(data.get(0));
		
		
		Actions action=new Actions(driver);
		action.moveToElement(College_activation_pom.logo).click().build().perform();
		
		
		StringSelection string=new StringSelection(data.get(1));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		Robot robot=new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		College_activation_pom.address.sendKeys(data.get(2));
		//Thread.sleep(1000);
		
		College_activation_pom.location.sendKeys(data.get(3));
		//Thread.sleep(1000);
		
		Select select=new Select(College_activation_pom.affliation);
		select.selectByVisibleText(data.get(4));
		//Thread.sleep(1000);
		
		Select select1=new Select(College_activation_pom.affliated_to);
		select1.selectByVisibleText(data.get(5));
		//Thread.sleep(1000);
		
		Select select2=new Select(College_activation_pom.college_type);
		select2.selectByVisibleText(data.get(6));
		
		//for(int a=1;a<=9;a++) {
			if(data.get(6).equals("Professional")) {
				//College_activation_pom.professional_ug.click();
			    Thread.sleep(1000);
			    WebDriverWait wait6=new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait6.until(ExpectedConditions.elementToBeClickable(College_activation_pom.professional_pg)).click();
			   }else if(data.get(6).equals("ITI")) {
			    Thread.sleep(1000);
			    College_activation_pom.polytechnic.click();
		//	}
		}
		
		College_activation_pom.contact_name.sendKeys(data.get(7));
		//Thread.sleep(1000);
		
		College_activation_pom.contact_number.sendKeys(data.get(8));
		//Thread.sleep(1000);
		
		College_activation_pom.email.sendKeys(data.get(9));
		//Thread.sleep(1000);
		
		College_activation_pom.contact_name_placement.sendKeys(data.get(10));
		//Thread.sleep(1000);
		
		College_activation_pom.contact_number_placement.sendKeys(data.get(11));
		//Thread.sleep(1000);
		
		College_activation_pom.email_placement.sendKeys(data.get(12));
		
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		
		Thread.sleep(2000);
		WebDriverWait wait4=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait4.until(ExpectedConditions.elementToBeClickable(College_activation_pom.submit_button));
		Actions action2=new Actions(driver);
		action2.moveToElement(College_activation_pom.submit_button).click().build().perform();
		//Thread.sleep(3000);
		
		WebDriverWait wait5=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		wait5.until(ExpectedConditions.elementToBeClickable(College_activation_pom.add_2)).click();
		//Thread.sleep(2000);
		
		data.clear();

		
		}

		
	}

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		// TODO Auto-generated method stub
			
          //  try {
            	activation();
           // }
           // catch(Exception e){
            	//College_activation_baseclass.takescreenshot();
          //  }

	}

}
