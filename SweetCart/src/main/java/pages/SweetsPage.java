package pages;

import org.openqa.selenium.*;
import java.util.List;
import base.BasePage;

public class SweetsPage extends BasePage {

    public SweetsPage(WebDriver driver) {
        super(driver);
    }

    By sweetsLink = By.xpath("//a[@href='/sweets']");
    By productCards = By.xpath("//div[contains(@class,'card')]");

    // Open sweets page
    public void openSweetsPage() {
        click(sweetsLink);
        waitForElement(productCards);
    }

    // Verify multiple products
    public int getProductCount() {
        return driver.findElements(productCards).size();
    }

    // Verify Add to Basket button exists (NOT strict for all)
    public boolean isAddToBasketPresent() {

        List<WebElement> buttons = driver.findElements(
                By.xpath("//a[contains(@class,'addItem')]")
        );

        return buttons.size() > 0;
    }

    // Print specific product details
    public void printProductDetails(String productName) {

        List<WebElement> products = driver.findElements(productCards);

        for (WebElement product : products) {

            String name = product.findElement(By.className("card-title")).getText();

            if (name.equalsIgnoreCase(productName)) {

                String description = product.findElement(By.className("card-text")).getText();
                String price = product.findElement(By.className("text-muted")).getText();

                System.out.println("Product Name: " + name);
                System.out.println("Description: " + description);
                System.out.println("Price: " + price);

                return;
            }
        }

        throw new RuntimeException("Product not found: " + productName);
    }
}