package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C12 {
    //1. tarayıcıyı başlat
    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
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
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        Thread.sleep(2000);

        //6. 'Alışverişe Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        //7. Fareyle ikinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //9. Her iki ürünün de Sepete eklendiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/product_details/1']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/product_details/2']")).isDisplayed());

        //10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın
        Assert.assertTrue(driver.findElement(By.cssSelector("#product-1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#product-2")).isDisplayed());
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
