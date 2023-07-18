package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C13 {
    //1. tarayıcıyı başlat
    static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());

        //4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        driver.navigate().back();
        driver.navigate().forward();
        //5. Ürün detayının açıldığını doğrulayın
        driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed();
        //6. Miktarı 4'e yükseltin

        driver.findElement(By.cssSelector("#quantity")).sendKeys(Keys.DELETE,"4");

        //7. 'Sepete ekle' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        //9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='table-responsive cart_info']")).isDisplayed());
    }
}
