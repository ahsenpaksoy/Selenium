package automationExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C05 {
    public static void main(String[] args) throws InterruptedException {
        //1. Tarayıcıyı başlatın
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement baslik=driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        System.out.println(baslik.isDisplayed());
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        System.out.println(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        //6. Adı ve kayıtlı e-posta adresini girin
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Rana");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("ranabetul987@gmail.com");

        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(3000);

        //8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür
        if (driver.findElement(By.xpath("//p[.='Email Address already exist!']")).getText().equals("Email Address already exist!")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        System.out.println(driver.findElement(By.xpath("//p[.='Email Address already exist!']")).isDisplayed());

    }
}
