package com.thiru.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties config;
	public static Properties OR;
	public static Logger log ;
	public static WebDriverWait wait ;
	public static Date d;
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		d= new Date();
		config = new Properties();
		OR = new Properties();
		   System.out.println("Working Directory = " + System.getProperty("user.dir"));
		PropertyConfigurator.configure(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\log4j.properties");
		log = Logger.getLogger("devpinoylogger");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		log.debug("Config File Loaded");

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		log.debug("Object Repository  File Loaded");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 3);
		log.debug("Chrome Driver Initialized");
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigating to Homepage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwaitduration")), TimeUnit.SECONDS);
	}

	
	public Boolean isElementPresent(By by) {
	try {
		driver.findElement(by);
		return true;
		
	}catch(NoSuchElementException e) {
		return false;
		
	}
	}
	
	
	@AfterSuite
	public void tearDown() {
		
		if (driver!=null) {
			driver.quit();
			log.debug("Closing the chromedriver");
		}

	}

}
