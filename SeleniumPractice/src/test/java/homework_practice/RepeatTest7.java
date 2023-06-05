package homework_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RepeatTest7 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);

        // Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(1000);

        // Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(1000);

        // Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(1000);

        // Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProduct = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        System.out.println("Ilk urunun ismi : " + firstProduct.getText());
        firstProduct.click();
        Thread.sleep(1000);

        // Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(1000);

        // Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        Thread.sleep(1000);

        // Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement productAvailable = driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        if(productAvailable.isDisplayed()){
            System.out.println("Product is added");
        }else System.out.println("Product is not added");

        // Sayfayi kapatin
        driver.close();




    }
}
