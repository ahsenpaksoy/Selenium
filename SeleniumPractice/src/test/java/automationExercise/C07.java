package automationExercise;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C07 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Test Durumları' düğmesine tıklayın
    //5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void autumationExercise() {
        driver.get("http://automationexercise.com");
        System.out.println(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        driver.findElement(By.xpath("(//button[text()=.])[1]")).click();
        driver.navigate().back();
        driver.navigate().forward();

        System.out.println(driver.findElement(By.xpath("//h2//b")).isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
