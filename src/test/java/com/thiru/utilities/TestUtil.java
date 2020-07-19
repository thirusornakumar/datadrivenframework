package com.thiru.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import  com.thiru.utilities.ExcelUtil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.thiru.base.TestBase;

public class TestUtil extends TestBase {
	
	public static  String screenshotname;
	

 public static void captureScreenshot() throws IOException {
	 
	  screenshotname= d.toString().replace(" ", "_").replace(":", "_")+"error.JPG";
	 
	File srcFile= ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotname));

 }
 
 @DataProvider(name = "getDataFromExcel")
 public static Iterator<Object []> getDataFromExcel() {
	 
	  ArrayList<Object[]> mydata = new ArrayList<Object[]>();
   ExcelUtil eUtil = new ExcelUtil(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\Testdata.xls");
   
   for(int rownum=2; rownum<=eUtil.getRowCount("AddCustomerTest");rownum++)
   {
	   String firstname = eUtil.getCellData("AddCustomerTest", "FirstName", rownum);
	   String lastname = eUtil.getCellData("AddCustomerTest", "LastName", rownum);
	   String postcode = eUtil.getCellData("AddCustomerTest", "PostCode", rownum);
	   
	   Object ab[]= {firstname,lastname,postcode};
	   mydata.add(ab);
   }
   
return mydata.iterator();
 

 
}
}