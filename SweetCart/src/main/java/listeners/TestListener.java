package listeners;

import org.testng.*;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtil;

import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).driver;

        String path = ScreenshotUtil.capture(driver, result.getName());

        test.fail("Test Failed");
        test.fail(result.getThrowable());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Flushing Extent Report...");
        extent.flush();
    }
}