package com.thiru.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.thiru.utilities.TestUtil;

public class CustomListeners implements ITestListener {
	
	public void onTestFailure(ITestResult arg0) {
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a target = \"-blank\" href = "+TestUtil.screenshotname+"> screenshot</a>");

}
}