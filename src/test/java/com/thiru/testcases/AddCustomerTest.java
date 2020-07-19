package com.thiru.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thiru.base.TestBase;
import com.thiru.utilities.TestUtil;


public class AddCustomerTest extends TestBase{
	
	@Test(dataProvider = "getDataFromExcel", dataProviderClass = TestUtil.class)
	public void addCustomer(String firstname, String lastname, String postcode) throws InterruptedException {
		
		System.out.println(firstname +"   "+ lastname+"    "+ postcode);
		
		driver.findElement(By.xpath(OR.getProperty("addcustomerbuttonxpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("customerfirstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(OR.getProperty("customerlastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(OR.getProperty("customerpostalcode"))).sendKeys(postcode);
		driver.findElement(By.xpath(OR.getProperty("customeraddbtn"))).click();
		
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		alert.accept();
		driver.findElement(By.xpath(OR.getProperty("customerfirstname"))).sendKeys("");
		driver.findElement(By.xpath(OR.getProperty("customerlastname"))).sendKeys("");
		driver.findElement(By.xpath(OR.getProperty("customerpostalcode"))).sendKeys("");
		
		Thread.sleep(2000);


		
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		

		
		Object [][] data = new Object[2][3];
		data[0][0]= "Raghav";
		data[0][1]= "Mital";
		data[0][2]= "A54666";
		
		data[1][0]= "Blki";
		data[1][1]= "Kilop";
		data[1][2]= "B4545";
		
	
		return data;
		
		
	}

}
