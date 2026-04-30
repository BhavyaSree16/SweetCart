package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        // Only for invalid login test
        if (result.getName().equalsIgnoreCase("testAuthentication")) {

            Object[] params = result.getParameters();

            // Check if this was invalid login case
            if (params.length == 3 && params[2].toString().equalsIgnoreCase("FALSE")) {

                Object currentClass = result.getInstance();
                WebDriver driver = ((BaseTest) currentClass).driver;

                ScreenshotUtil.capture(driver, "InvalidLogin");
            }
        }
    }
}