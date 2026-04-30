//package tests;
//
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import base.BaseTest;
//import pages.LoginPage;
//import pages.AccountPage;
//
//public class AccountTest extends BaseTest {
//
//    LoginPage loginPage;
//    AccountPage accountPage;
//
//    @BeforeMethod
//    public void setup() {
//        loginPage = new LoginPage(driver);
//        accountPage = new AccountPage(driver);
//    }
//
//    @Test
//    public void testAccountModule() {
//
//        System.out.println("Starting Account Module Test");
//
//        loginPage.openLoginPage();
//        loginPage.login("oneorder@sweetshop.local", "qwerty");
//
//        System.out.println("Login completed");
//
//        Assert.assertTrue(
//                accountPage.isAccountPageLoaded(),
//                "Account page not loaded"
//        );
//
//        Assert.assertTrue(
//                accountPage.isOrderSectionPresent(),
//                "Order section not present"
//        );
//
//        Assert.assertTrue(
//                accountPage.isOrderDataValid(),
//                "Order data invalid"
//        );
//
//        System.out.println("Account Module Test Completed Successfully");
//    }
//}

package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.LoginPage;
import pages.AccountPage;

public class AccountTest extends BaseTest {

    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void testAccountModule() {

        System.out.println("Starting Account Module Test");

        loginPage.openLoginPage();
        loginPage.login("oneorder@sweetshop.local", "qwerty");

        System.out.println("Login completed");

        Assert.assertTrue(
                accountPage.isAccountPageLoaded(),
                "Account page not loaded"
        );

        Assert.assertTrue(
                accountPage.isOrderSectionPresent(),
                "Order section not present"
        );

        Assert.assertTrue(
                accountPage.isOrderDataValid(),
                "Order data invalid"
        );

        System.out.println("Account Module Test Completed Successfully");
    }
}