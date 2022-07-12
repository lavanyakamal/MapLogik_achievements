package com.college_activation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Import_marks {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		String college_name,file_name,course_type,department,sheet_name_d,location;
		System.out.println("Enter the college name to be searched:");
		college_name=s.nextLine();
		
		int n,ci,sheet_no,c,semester;
		n=0;c=0;
		System.out.println("Enter the index of college:");
		Scanner s1=new Scanner(System.in);
		ci=s1.nextInt();
		
	/*	System.out.println("Enter the sheet name in location file:");
		sheet_name_l=s.nextLine();*/
		
		System.out.println("Enter the sheet name in department file:");
		sheet_name_d=s.nextLine();
		
		System.out.println("Enter the course type:");
		course_type=s.nextLine();
		
		System.out.println("Enter the location:");
		location=s.nextLine();
		
	/*	System.out.println("Enter the semester number:");
		semester=s.nextInt();*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavanya\\chromedriver\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://maplogik.com/index.php/admin/login");
		driver.findElement(By.id("login-email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		WebElement college_active=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='College Activation']")));
		college_active.click();
		
		WebElement search=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='search']")));
		search.sendKeys(college_name);
		
		WebElement import_mark=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='datatable']/tbody/tr["+ci+"]/td[4]/a[4]")));
		import_mark.click();
		
		List<String> dept=new ArrayList<String>();
		List<String> dept_excel=new ArrayList<String>();
		
		File file=new File("D:\\MapLogiK\\marks\\"+college_name+"\\location\\"+location+".xlsx");
		File file2=new File("D:\\MapLogiK\\import_student\\departments.xlsx");
		FileInputStream input=new FileInputStream(file);
		FileInputStream input2=new FileInputStream(file2);
		
		XSSFWorkbook workbook2=new XSSFWorkbook(input2);
		XSSFSheet sheet2=workbook2.getSheet(sheet_name_d);
		int row_no2=sheet2.getLastRowNum();
		
		for(int k=0;k<row_no2;k++) {
			String d=sheet2.getRow(k).getCell(0).getStringCellValue();
			System.out.println(d);
			dept_excel.add(d);
		}
		
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		
		//int row_no=sheet.getLastRowNum();
		
		//System.out.println(row_no);
		for(int i=0;i<row_no2;i++) {
		//System.out.println(file_path);
			
		semester=1;
		
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
		
		for(int a=0;a<5;a++) {
		Thread.sleep(2000);
		Select select3=new Select(driver.findElement(By.xpath("//*[@name='semester']")));
		select3.selectByIndex(semester);
		
		Thread.sleep(3000);
		XSSFSheet sheet=workbook.getSheet(dept_excel.get(c));
		String file_path=sheet.getRow(a).getCell(0).getStringCellValue();
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
		
		Select select4=new Select(driver.findElement(By.xpath("//*[@name='course_type']")));
		select4.selectByVisibleText(course_type);
		
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
		
		semester++;
		}
		
		c++;
		
		Thread.sleep(1000);

		}
	}

}
