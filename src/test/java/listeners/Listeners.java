package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReporter;

public class Listeners implements ITestListener {
	
	WebDriver driver = null;
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		extentTest = extentReport.createTest(testName+" execution started");
		
	}

	public void onTestSuccess(ITestResult result) {

		String testName = result.getName();
		extentTest.log(Status.PASS,testName+" passed successfully!");

	}

	public void onTestFailure(ITestResult result) {

//		String testName = result.getName();
		extentTest.fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {

		extentReport.flush();
	
	}
}