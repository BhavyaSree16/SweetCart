package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.LoginPage;
import pages.SweetsPage;
import pages.BasketPage;

public class BasketTest extends BaseTest {

    LoginPage loginPage;
    SweetsPage sweetsPage;
    BasketPage basketPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        sweetsPage = new SweetsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test
    public void testBasketModule() {

        loginPage.openLoginPage();
        loginPage.login("oneorder@sweetshop.local", "qwerty");

        Assert.assertTrue(loginPage.isLoginSuccessful());

        sweetsPage.openSweetsPage();

        basketPage.addFirstProductToBasket();

        basketPage.openBasket();

        Assert.assertTrue(
                basketPage.isBasketPageOpened(),
                "Basket page not opened"
        );

        driver.navigate().back();

        sweetsPage.openSweetsPage();

        basketPage.addMultipleProducts(2);

        basketPage.openBasket();

        Assert.assertTrue(
                basketPage.isBasketPageOpened(),
                "Basket page not opened after multiple add"
        );
    }
}