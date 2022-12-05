package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;

import ReusableMethodPackage.ReusableMethods;






public class Listeners extends ReusableMethods implements ITestListener {
WebDriver driver;
ExtentReports reports;
ExtentTest t;
String path;

ThreadLocal<ExtentTest> th;
	@Override
	public void onTestStart(ITestResult result) {
		reports= CustomizeReport();
		 t=reports.createTest(result.getMethod().getMethodName());
		th=new ThreadLocal<ExtentTest>();
		th.set(t);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			System.out.println(driver);
			ScreenShot(driver,result.getMethod().getMethodName());
		} catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			path = ScreenShotPath(driver,result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			ScreenShot(driver,result.getMethod().getMethodName());
		} catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

}
