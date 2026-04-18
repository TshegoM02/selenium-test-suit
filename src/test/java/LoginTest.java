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

        WebElement username = driver.findElement(By.id("username")); // Find username element using its HTML id.
        username.sendKeys("tomsmith"); // Enter text

        WebElement password = driver.findElement(By.id("password")); // Find password field
        password.sendKeys("SuperSecretPassword!"); // Enter password

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']")); // Find button written 'Submit'
        loginButton.click(); // Click 'Submit' button

        WebElement successMessage = driver.findElement(By.id("flash")); // Verify success message

        //System.out.println(successMessage.getText());

        assertTrue(successMessage.getText().contains("secure area!"));
    }
    // Negative test
    @Test
    void testInvalidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("WrongPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement errorMessage = driver.findElement(By.id("flash"));

        System.out.println(errorMessage.getText());

        assertTrue(errorMessage.getText().contains("Your Password is invalid"));
    }

    @AfterEach
    void tearDown() { // Runs after every test

        driver.quit(); // Closes browser 'Chrome'
    }
}
