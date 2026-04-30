package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import base.BasePage;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    By addButtons = By.xpath("//a[contains(@class,'addItem')]");
    By basketLink = By.xpath("//a[contains(@href,'basket')]");

    public void addFirstProductToBasket() {

        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(addButtons)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void addMultipleProducts(int count) {

        List<WebElement> buttons = driver.findElements(addButtons);

        for (int i = 0; i < count && i < buttons.size(); i++) {

            WebElement btn = buttons.get(i);

            wait.until(ExpectedConditions.elementToBeClickable(btn));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }

    public void openBasket() {

        WebElement basket = wait.until(
                ExpectedConditions.elementToBeClickable(basketLink)
        );

        basket.click();

        wait.until(ExpectedConditions.urlContains("basket"));
    }

    public boolean isBasketPageOpened() {
        return driver.getCurrentUrl().contains("basket");
    }
}