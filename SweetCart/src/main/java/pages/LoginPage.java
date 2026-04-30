package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By loginLink = By.xpath("//a[contains(text(),'Login')]");
    By email = By.cssSelector("input[type='email']");
    By password = By.cssSelector("input[type='password']");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    By sweetsLink = By.xpath("//a[@href='/sweets']");

    public void openLoginPage() {
        click(loginLink);
        waitForElement(email);
    }

    public void login(String user, String pass) {
        sendKeys(email, user);
        sendKeys(password, pass);
        click(loginBtn);
    }

    public boolean isLoginSuccessful() {
        return !driver.getCurrentUrl().contains("login");
    }

    public void goToSweetsPage() {
        click(sweetsLink);
    }
}