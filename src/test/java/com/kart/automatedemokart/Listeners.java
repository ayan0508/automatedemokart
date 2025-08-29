package com.kart.automatedemokart;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.util.Extentreport;
import com.util.ScreenshotUtil;

public class Listeners implements ITestListener {
    private static ExtentReports extent = Extentreport.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }
	public void onTestSuccess(ITestResult result)	
	{
		test.get().pass("Test passed");
	}
	public void onTestFailure(ITestResult result)
	{
		Object testInstance = result.getInstance();
        WebDriver driver = ((DemoKartTestSuite) testInstance).getDriver(); // assuming BaseTest has getDriver()
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
        test.get().fail(result.getThrowable());
        test.get().addScreenCaptureFromPath(screenshotPath);
	}
	public void onTestSkipped(ITestResult result)
	{
		test.get().skip("Test skipped: " + result.getName());
	}
	public void onFinish(ITestContext context) {
        extent.flush(); 
    }
}
