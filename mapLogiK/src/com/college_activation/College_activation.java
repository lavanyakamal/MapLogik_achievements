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

public class College_activation {

	public static void main(String[] args) throws AWTException, InterruptedException {
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
		college.sendKeys("peter engineering college");
		
		Actions action=new Actions(driver);
		WebElement logo=driver.findElement(By.name("logo"));
		action.moveToElement(logo).click().build().perform();
		
		
		StringSelection string=new StringSelection("pictures\\1.jpg");
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
		driver.findElement(By.id("address")).sendKeys("4th cross street,tambaram,chennai");
		//Thread.sleep(1000);
		driver.findElement(By.id("location")).sendKeys("chennai");
		//Thread.sleep(1000);
		WebElement affliation=driver.findElement(By.name("affliation"));
		Select select=new Select(affliation);
		select.selectByIndex(1);
		//Thread.sleep(1000);
		WebElement affliation2=driver.findElement(By.name("affliated_to"));
		Select select1=new Select(affliation2);
		select1.selectByIndex(1);
		//Thread.sleep(1000);
		WebElement college_type=driver.findElement(By.name("college_type"));
		Select select2=new Select(college_type);
		select2.selectByIndex(1);//
		//Thread.sleep(1000);////*[@name='course[]_helper1']/child::*[1]"
		driver.findElement(By.xpath("//*[@title='Move all'][1]")).click();
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_name")).sendKeys("peter");
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_number")).sendKeys("9443378967");
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_email")).sendKeys("peter@gmail.com");
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_name_plc")).sendKeys("divya");
		//Thread.sleep(1000);
		driver.findElement(By.id("cnt_number_plc")).sendKeys("9878654234");
		//Thread.sleep(1000);
		driver.findElement(By.id("course_email_plc")).sendKeys("divya@gmail.com");
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		
		Thread.sleep(2000);
		WebDriverWait wait4=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button=wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Submit']")));
		Actions action2=new Actions(driver);
		action2.moveToElement(button).click().build().perform();

	}

}
