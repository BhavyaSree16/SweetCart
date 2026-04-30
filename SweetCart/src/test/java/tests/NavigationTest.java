package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.NavigationPage;

public class NavigationTest extends BaseTest {

    NavigationPage navigationPage;

    @BeforeMethod
    public void setup() {
        navigationPage = new NavigationPage(driver);
    }

    @Test
    public void testNavigationModule() {

        System.out.println("Starting Navigation Test");

        // Verify navigation links
        Assert.assertTrue(
                navigationPage.areNavLinksPresent(),
                "Navigation links missing"
        );

        // Navigate to About page
        navigationPage.clickAbout();

        Assert.assertTrue(
                navigationPage.isAboutPageLoaded(),
                "About page not loaded"
        );

        // Verify footer
        Assert.assertTrue(
                navigationPage.isFooterPresent(),
                "Footer not present"
        );

        Assert.assertTrue(
                navigationPage.areFooterLinksPresent(),
                "Footer links missing"
        );

        System.out.println("Navigation Test Completed Successfully");
    }
}