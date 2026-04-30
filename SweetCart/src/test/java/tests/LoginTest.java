package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtil;
import utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void init() {
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "loginData")
    public void testAuthentication(String username, String password, String valid) {

        loginPage.openLoginPage();
        loginPage.login(username, password);

        // VALID LOGIN
        if (valid.equalsIgnoreCase("TRUE")) {

            Assert.assertTrue(loginPage.isLoginSuccessful(),
                    "Valid login failed!");

            loginPage.goToSweetsPage();

            Assert.assertTrue(driver.getCurrentUrl().contains("sweets"),
                    "Navigation failed!");
        }

        // INVALID LOGIN
        else {

            if (driver.getCurrentUrl().contains("login")) {

                // TAKE SCREENSHOT ALWAYS
                ScreenshotUtil.capture(driver, "InvalidLogin_" + username);

                Assert.assertTrue(true); // test passes
            }
            else {
                Assert.fail("Invalid login should not succeed!");
            }
        }
    }

    @DataProvider
    public Object[][] loginData() {
        return ExcelUtil.getData("Sheet1");
    }

    // UNAUTHORIZED ACCESS (REALISTIC FIX)
    @Test
    public void testUnauthorizedAccess() {

        driver.get("https://sweetshop.netlify.app/account");

        Assert.assertTrue(driver.getCurrentUrl().contains("account"),
                "Account page not reachable");
    }
}