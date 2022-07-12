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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class College_activation_excel {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavanya\\chromedriver\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://maplogik.com/index.php/admin/login");
		driver.findElement(By.id("login-email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		WebElement college_active=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='College Activation']")));
		college_active.click();
		
		WebElement add_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='http://maplogik.com/index.php/admin/college/addCollege']")));
		add_button.click();
		
		File file=new File("D:\\MapLogiK\\39 colleges\\b coll act.xlsx");
		FileInputStream input=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheet("sheet2");
		int row_no=sheet.getLastRowNum();
		System.out.println(row_no);
		int column_no=sheet.getRow(0).getLastCellNum();
		System.out.println(column_no);
		List<String> data=new ArrayList<String>();
		
		for(int i=0;i<=row_no;i++) {
		for(int j=0;j<=column_no;j++) {
			Cell cell=sheet.getRow(i).getCell(j);
			DataFormatter new_data=new DataFormatter();
			String info=new_data.formatCellValue(cell);
			data.add(info);
		}
		
		int list_size=data.size();
		for(int k=0;k<list_size;k++) {
			System.out.println(data.get(k));
		}

		WebElement college=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("course_name")));
		college.sendKeys(data.get(0));
		
		Actions action=new Actions(driver);
		WebElement logo=driver.findElement(By.name("logo"));
		action.moveToElement(logo).click().build().perform();
		
		
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
		
		driver.findElement(By.id("address")).sendKeys(data.get(2));
		//Thread.sleep(1000);
		
		driver.findElement(By.id("location")).sendKeys(data.get(3));
		//Thread.sleep(1000);
		
		WebElement affliation=driver.findElement(By.name("affliation"));
		Select select=new Select(affliation);
		select.selectByVisibleText(data.get(4));
		//Thread.sleep(1000);
		
		WebElement affliation2=driver.findElement(By.name("affliated_to"));
		Select select1=new Select(affliation2);
		select1.selectByVisibleText(data.get(5));
		//Thread.sleep(1000);
		
		WebElement college_type=driver.findElement(By.name("college_type"));
		Select select2=new Select(college_type);
		select2.selectByVisibleText(data.get(6));
		
	/*	for(int a=1;a<=9;a++) {
			if(data.get(6).equals("Professional")) {*/
			driver.findElement(By.xpath("//*[@title='Move all'][1]")).click();
			Thread.sleep(1000);
		/*	driver.findElement(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_course1[]']/option["+a+"]")).click();
			}else if(data.get(6).equals("ITI")) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_course2[]']/option["+a+"]")).click();
			}
		}*/
		
		driver.findElement(By.id("cnt_name")).sendKeys(data.get(7));
		//Thread.sleep(1000);
		
		driver.findElement(By.id("cnt_number")).sendKeys(data.get(8));
		//Thread.sleep(1000);
		
		driver.findElement(By.id("cnt_email")).sendKeys(data.get(9));
		//Thread.sleep(1000);
		
		driver.findElement(By.id("cnt_name_plc")).sendKeys(data.get(10));
		//Thread.sleep(1000);
		
		driver.findElement(By.id("cnt_number_plc")).sendKeys(data.get(11));
		//Thread.sleep(1000);
		
		driver.findElement(By.id("course_email_plc")).sendKeys(data.get(12));
		
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		
		Thread.sleep(2000);
		WebElement button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Submit']")));
		Actions action2=new Actions(driver);
		action2.moveToElement(button).click().build().perform();
		//Thread.sleep(3000);
		
		WebElement add_button2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='http://maplogik.com/index.php/admin/college/addCollege']")));
		add_button2.click();
		//Thread.sleep(2000);
		
		data.clear();

		
		}
	
	}
}
