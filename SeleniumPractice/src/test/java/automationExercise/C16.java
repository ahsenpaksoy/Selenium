package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C16 {
    // Launch browser
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Verify that home page is visible successfully
        WebElement text = driver.findElement(By.xpath("//div[@class='logo pull-left']"));


        // Click 'Signup / Login' button
        // Fill email, password and click 'Login' button
        // Verify 'Logged in as username' at top
        // Add products to cart
        // Click 'Cart' button
        // Verify that cart page is displayed
        // Click Proceed To Checkout
        // Verify Address Details and Review Your Order
        // Enter description in comment text area and click 'Place Order'
        // Enter payment details: Name on Card, Card Number, CVC, Expiration date
        // Click 'Pay and Confirm Order' button
        // Verify success message 'Your order has been placed successfully!'
        // Click 'Delete Account' button
        // Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
