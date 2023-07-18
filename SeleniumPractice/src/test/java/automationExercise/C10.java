package automationExercise;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
public class C10 {
    //1. Tarayıcıyı başlatın
    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());
        //4. Altbilgiye doğru aşağı kaydırın
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //5. 'ABONELİK' metnini doğrulayın
        WebElement subcription=driver.findElement(By.xpath("//*[.='Subscription']"));
        Assert.assertTrue(subcription.isDisplayed());

        //6. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        WebElement email=driver.findElement(By.cssSelector("#susbscribe_email"));
        email.sendKeys("ranabetul987@gmail.com");
        driver.findElement(By.cssSelector("#subscribe")).click();

        //7. Başarı mesajını doğrulayın 'Başarıyla abone oldunuz!' görünür
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='alert-success alert']")).isDisplayed());
    }
    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
