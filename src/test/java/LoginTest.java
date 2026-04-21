import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager; // Sets up ChromeDriver
import org.junit.jupiter.api.*; // Make code test by @Test, @BeforeEach, @AfterEach
import org.openqa.selenium.WebDriver; // Browser controller
import org.openqa.selenium.chrome.ChromeDriver;// Chrome browser
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*; // Gives assertTrue()

public class LoginTest { // 1st class, container for tests

    WebDriver driver; // Variable, browser, Chrome remote control

    @BeforeEach
    void setUp() { // Runs before every test
        WebDriverManager.chromedriver().setup(); // Download and sets up Chrome, can't open Chrome without
        driver = new ChromeDriver();// Opens a new Chrome browser that tests can control
        driver.manage().window().maximize();

        driver.manage() .timeouts() .implicitlyWait(java.time.Duration.ofSeconds(5));
    }

    @Test // JUnit knows to test
    void testGoogleTitle() { // The test
        driver.get("https://www.google.com"); // Opens 'Google', like typing in browser
        String title = driver.getTitle(); // Gets age title 'Google'

        assertTrue(title.contains("Google")); // Checks, if the title contains 'Google' it passes, otherwise fail
    }

    // Positive test
    @Test
    void testValidLogin() {
        // Open login page
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver); // Create a login page object and give it the browser to use
        loginPage.login("tomsmith", "SuperSecretPassword!");

        WebElement successMessage = driver.findElement(By.id("flash")); // Verify success message

        String text = successMessage.getText().trim();

        //System.out.println(successMessage.getText());

        assertTrue(text.toLowerCase().contains("secure area!"));
    }
    // Negative test
    @Test
    void testInvalidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "WrongPassword!");

        WebElement errorMessage = driver.findElement(By.id("flash"));

        String text = errorMessage.getText().trim(); // The message = error message, visibly appear, remove spaces/newlines

        System.out.println(errorMessage.getText());

        // Check the message includes 'invalid'
        assertTrue(text.toLowerCase().contains("invalid!")); // Ignore uppercase/lowercase difference
    }

    @AfterEach
    void tearDown() { // Runs after every test

        driver.quit(); // Closes browser 'Chrome'
    }
}
