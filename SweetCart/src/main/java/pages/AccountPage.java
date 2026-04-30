package pages;

import org.openqa.selenium.*;
import java.util.List;
import base.BasePage;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    By accountHeading = By.xpath("//*[contains(text(),'Your Account')]");
    By orderCount = By.id("accountOrderCount");
    By orderRows = By.xpath("//table//tbody//tr");

    public boolean isAccountPageLoaded() {

        try {
            boolean status = waitForElement(accountHeading).isDisplayed();
            System.out.println("Account page loaded: " + status);
            return status;
        } catch (Exception e) {
            System.out.println("Account page not loaded");
            return false;
        }
    }

    public boolean isOrderSectionPresent() {

        boolean status = driver.findElements(orderCount).size() > 0;
        System.out.println("Order section present: " + status);
        return status;
    }

    public boolean isOrderDataValid() {

        List<WebElement> rows = driver.findElements(orderRows);

        System.out.println("Total orders found: " + rows.size());

        if (rows.size() == 0) {
            System.out.println("No order rows found but section exists");
            return true;
        }

        for (WebElement row : rows) {

            List<WebElement> columns = row.findElements(By.tagName("td"));

            System.out.println("----- Order Row -----");

            for (int i = 0; i < columns.size(); i++) {

                String value = columns.get(i).getText();
                System.out.println("Column " + (i + 1) + ": " + value);

                if (value.contains("£") || value.matches("\\d+\\.\\d+")) {
                    System.out.println("Order Total: " + value);
                }
            }

            if (columns.size() == 0) {
                System.out.println("Invalid order row found");
                return false;
            }
        }

        System.out.println("All order data valid");
        return true;
    }
}