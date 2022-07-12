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
import java.util.Scanner;

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

public class Import_student {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		String college_name,file_name,course_type,department,sheet_name_l,sheet_name_d;
		System.out.println("Enter the college name to be searched:");
		college_name=s.nextLine();
		
		int n,ci,sheet_no,c;
		n=0;c=0;
		System.out.println("Enter the index of college:");
		Scanner s1=new Scanner(System.in);
		ci=s1.nextInt();
		
		/*System.out.println("Enter the file name:");
		file_name=s.nextLine();*/
		
		System.out.println("Enter the sheet name in location file:");
		sheet_name_l=s.nextLine();
		
	/*	System.out.println("Enter the sheet name in department file:");
		sheet_name_d=s.nextLine();*/
		
		System.out.println("Enter the course type:");
		course_type=s.nextLine();
		
	/*	System.out.println("Enter the department name:");
		department=s.nextLine();*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavanya\\chromedriver\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://maplogik.com/index.php/admin/login");
		driver.findElement(By.id("login-email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10000));//div[@class='pace pace-inactive']/parent::body
		WebElement college_active=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='College Activation']")));
		college_active.click();
		
		WebElement search=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='search']")));
		search.sendKeys(college_name);
		
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		Thread.sleep(1000);
		
	/*	WebElement next=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		next.click();////table[@id='datatable']/tbody/tr[15]/td[4]/a[3]*/
		
		WebElement import_std=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='datatable']/tbody/tr["+ci+"]/td[4]/a[3]")));
		import_std.click();
		
		File file=new File("D:\\MapLogiK\\39 colleges\\b location.xlsx");
		File file2=new File("D:\\MapLogiK\\39 colleges\\dept.xlsx");
		FileInputStream input=new FileInputStream(file);
		FileInputStream input2=new FileInputStream(file2);
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheet(sheet_name_l);
		int row_no=sheet.getLastRowNum();
		
		XSSFWorkbook workbook2=new XSSFWorkbook(input2);
		XSSFSheet sheet2=workbook2.getSheetAt(0);
		int row_no2=sheet2.getLastRowNum();
		
		List<String> dept=new ArrayList<String>();
		List<String> dept_excel=new ArrayList<String>();
		
		for(int k=0;k<=1;k++) {
			String d=sheet2.getRow(k).getCell(0).getStringCellValue();
			System.out.println(d);
			dept_excel.add(d);
		}
		
		System.out.println(row_no);
		for(int i=0;i<=1;i++) {
			String file_path=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(file_path);
		
		Select select=new Select(driver.findElement(By.xpath("//*[@name='course_type']")));
		select.selectByVisibleText(course_type);
		
		List<WebElement> no_course=driver.findElements(By.xpath("//*[@id='course_name']/option"));
		int list_size=no_course.size();
		System.out.println(list_size);
		
		for(int j=2;j<=list_size;j++) {
			WebElement courses=driver.findElement(By.xpath("//*[@id='course_name']/option["+j+"]"));
			String course=courses.getText();
			System.out.println(course);
			dept.add(course);
		
		if(dept.get(n).contains(dept_excel.get(c)))
		{
		WebElement option=driver.findElement(By.xpath("//*[@id='course_name']"));
		Select select2=new Select(option);
		select2.selectByVisibleText(dept.get(n));
		}
		n++;
		}
		
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("import_file"))).click().build().perform();
		
				
		StringSelection string=new StringSelection(file_path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		Robot robot=new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(1000);
		driver.findElement(By.id("submitbtn")).click();
		
		c++;
		
		Thread.sleep(1000);
		
		}
		

	}

}
