package automationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C02 {
    public static void main(String[] args) {
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

        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        System.out.println(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("ranabetul987@gmail.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("123456");

        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());

        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //10. 'HESAP SİLİNDİ!' görünür
        System.out.println(driver.findElement(By.xpath("//h2//b")).isDisplayed());

    }
}
