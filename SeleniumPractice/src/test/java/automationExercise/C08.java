package automationExercise;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
public class C08 {
    //1. Tarayıcıyı başlatın
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01() {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());

        //4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        driver.navigate().back();
        driver.navigate().forward();
        WebElement urunler = driver.findElement(By.cssSelector("h2[class='title text-center']"));
        Assert.assertTrue(urunler.isDisplayed());

        //6. Ürün listesi görünür
        List<WebElement> urunlerList = driver.findElements(By.xpath("//div[@class='product-overlay']"));
        for (int i = 0; i < urunlerList.size(); i++) {
            urunlerList = driver.findElements(By.xpath("//div[@class='product-overlay']"));
            WebElement urun = urunlerList.get(i);
            Assert.assertTrue(urun.isDisplayed());

        }

        //7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        //8. Kullanıcı ürün detay sayfasına yönlendirildi
        WebElement firstUrun = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
        Assert.assertTrue(firstUrun.isDisplayed());

        //9. Ürün adı, kategorisi, fiyatı, bulunabilirliği, durumu, markası gibi ayrıntıların göründüğünü doğrulayın.
        WebElement ayrinti = driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']"));
        Assert.assertTrue(ayrinti.isDisplayed());
    }
}
