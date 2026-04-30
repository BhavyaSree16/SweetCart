package pages;

import org.openqa.selenium.*;
import java.util.List;
import base.BasePage;

public class NavigationPage extends BasePage {

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    By homeLink = By.xpath("//a[contains(text(),'Home')]");
    By sweetsLink = By.xpath("//a[contains(text(),'Sweets')]");
    By aboutLink = By.xpath("//a[contains(text(),'About')]");
    By loginLink = By.xpath("//a[contains(text(),'Login')]");

    By aboutHeading = By.xpath("//h1 | //h2");

    By footerLinks = By.xpath("//footer//a");
    By footerText = By.xpath("//footer");

    public boolean areNavLinksPresent() {

        boolean home = driver.findElements(homeLink).size() > 0;
        boolean sweets = driver.findElements(sweetsLink).size() > 0;
        boolean about = driver.findElements(aboutLink).size() > 0;
        boolean login = driver.findElements(loginLink).size() > 0;

        System.out.println("Home link present: " + home);
        System.out.println("Sweets link present: " + sweets);
        System.out.println("About link present: " + about);
        System.out.println("Login link present: " + login);

        return home && sweets && about && login;
    }

    public void clickAbout() {
        click(aboutLink);
    }

    public boolean isAboutPageLoaded() {

        try {
            String heading = waitForElement(aboutHeading).getText();
            System.out.println("About Page Heading: " + heading);

            return heading.toLowerCase().contains("about");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFooterPresent() {

        boolean present = driver.findElements(footerText).size() > 0;
        System.out.println("Footer present: " + present);

        return present;
    }

    public boolean areFooterLinksPresent() {

        List<WebElement> links = driver.findElements(footerLinks);

        System.out.println("Total footer links: " + links.size());

        return links.size() > 0;
    }
}