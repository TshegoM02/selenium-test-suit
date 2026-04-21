package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver; // Browser to interact with page

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver; // Take the browser from the test, store it inside this page
    }

    // Locators
    By usernameField = By.id("username"); // "How do I find username field on the page? = By using is username"
    By passwordField = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By message = By.id("flash");

    // Actions
    public void enterUsername(String username) { // Find username field, type whatever is given
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getMessageText() {
        return driver.findElement(message).getText().trim().toLowerCase();
    }

    public void login(String username, String password) { // Perform full login process
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
