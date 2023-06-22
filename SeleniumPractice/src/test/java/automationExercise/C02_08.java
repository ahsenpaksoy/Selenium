package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_08 extends TestBase {
    @Test
    public void test01() {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        bekle(2);

        // 3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());




        // 4. Click on 'Contact Us' button

        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();


        // 5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch=  driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(getInTouch.isDisplayed());


        // 6. Enter name, email, subject and message
        WebElement form = driver.findElement(By.xpath("//input[@name='name']"));
        form.sendKeys("Ali", Keys.TAB, "veli@gmail.com",Keys.TAB, "djknskdnfkldf",Keys.TAB,";kasflskdns;dlmsldkfep");


        // 7. Upload file

        //"C:\Users\zulfi\OneDrive\Masaüstü\teamSelenium.txt"

        WebElement file = driver.findElement(By.xpath("(//*[@class='form-control'])[5]"));
        String farkliYol = System.getProperty("user.home");
        String ortakYol = "\\OneDrive\\Masaüstü\\teamSelenium.txt";
        String yol = farkliYol+ortakYol;

        file.sendKeys(yol);



        // 8. Click 'Submit' button

        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();


        // 9. Click OK button
        driver.switchTo().alert().accept();
        // alertAccept();



        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement sonuc = driver.findElement(By.xpath("//div[@class= 'status alert alert-success']"));
        Assert.assertTrue(sonuc.isDisplayed());


        // 11. Click 'Home' button and verify that landed to home page successfully


    }
}
