package com.college_activation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class College_activation_single {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavanya\\chromedriver\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://maplogik.com/index.php/admin/login");
		driver.findElement(By.id("login-email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		WebElement college_active=wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='College Activation']")));
		college_active.click();
		
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		WebElement add_button=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='http://maplogik.com/index.php/admin/college/addCollege']")));
		add_button.click();
		
		WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(10));//div[@class='pace pace-inactive']/parent::body
		WebElement college=wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("course_name")));
		college.sendKeys("10 RK polytechnic college");
		
		Actions action=new Actions(driver);
		WebElement logo=driver.findElement(By.name("logo"));
		action.moveToElement(logo).click().build().perform();
		
		
		StringSelection string=new StringSelection("C:\\Users\\Lavanya\\Pictures\\5.jpg");
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
		driver.findElement(By.id("address")).sendKeys("gandhi street");
		//Thread.sleep(1000);
		driver.findElement(By.id("location")).sendKeys("Coimbatore");
		//Thread.sleep(1000);
		WebElement affliation=driver.findElement(By.name("affliation"));
		Select select=new Select(affliation);
		select.selectByVisibleText("Non Autonomous");
		//Thread.sleep(1000);
		WebElement affliation2=driver.findElement(By.name("affliated_to"));
		Select select1=new Select(affliation2);
		select1.selectByVisibleText("Madurai Kamaraj University");
		//Thread.sleep(1000);
		WebElement college_type=driver.findElement(By.name("college_type"));
		Select select2=new Select(college_type);
		select2.selectByVisibleText("ITI");//
		//Thread.sleep(1000);
		//for(int a=1;a<=9;a++) {
			//Thread.sleep(1000);
			driver.findElement(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_course[]']/preceding::div[1]")).click();
			//driver.findElement(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_course2[]']/option["+a+"]")).click();
		//}
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_name")).sendKeys("abi ");
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_number")).sendKeys("9876543249");
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_email")).sendKeys("abi@gmail.com");
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_name_plc")).sendKeys("amuthan");
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_number_plc")).sendKeys("9878654234");
		//Thread.sleep(1000);
		driver.findElement(By.id("course_email_plc")).sendKeys("amuthan@gmail.com");
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		
		Thread.sleep(2000);
		WebDriverWait wait4=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button=wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Submit']")));
		Actions action2=new Actions(driver);
		action2.moveToElement(button).click().build().perform();



	}

}
