package com.thiru.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.thiru.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginasBM() throws InterruptedException {
		
		log.debug("Inside the LonginasBM Method");
		driver.findElement(By.xpath(OR.getProperty("managerloginbuttonxpath"))).click();
		log.debug("Completed the LonginasBM Method");
		Thread.sleep(3000);
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addcustomerbuttonxpath"))), "Login not succesfull");
		log.debug("Succesfully logged in");
		
		Assert.fail("Login failed");
	
		
				
		
	}
	

	
	
	

}
