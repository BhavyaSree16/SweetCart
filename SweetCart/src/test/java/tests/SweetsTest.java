package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.LoginPage;
import pages.SweetsPage;

public class SweetsTest extends BaseTest {

    LoginPage loginPage;
    SweetsPage sweetsPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        sweetsPage = new SweetsPage(driver);
    }

    @Test
    public void testSweetsModule() {

        // Step 1: Login
        loginPage.openLoginPage();
        loginPage.login("oneorder@sweetshop.local", "qwerty");

        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Login failed!");

        // Step 2: Open sweets page
        sweetsPage.openSweetsPage();

        //1. Verify multiple products displayed
        int count = sweetsPage.getProductCount();
        System.out.println("Product count: " + count);

        Assert.assertTrue(count > 0, "No products displayed!");

        // 2. Verify Add to Basket button exists
        Assert.assertTrue(
                sweetsPage.isAddToBasketPresent(),
                "Add to Basket button not found!"
        );

        // 3. Print product details
        sweetsPage.printProductDetails("Chocolate Cups");
    }
}