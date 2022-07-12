package com.college_activation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class College_activation_baseclass {
	static WebDriver driver;
	public static WebDriver open_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavanya\\chromedriver\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://maplogik.com/index.php/admin/login");
		return driver;
	}
	
	public static void takescreenshot() throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\MapLogiK\\maplogik_defect.png");
		FileHandler.copy(source, destination);
	}

}
