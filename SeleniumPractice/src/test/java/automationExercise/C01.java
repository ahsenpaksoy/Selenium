package automationExercise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        //1. Tarayıcıyı başlat
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. URL'ye gidin 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.cssSelector("div[class='logo pull-left']")).isDisplayed());

        //4. 'Kaydol / Giriş' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. 'Yeni Kullanıcı Kaydı!' görünür
        System.out.println(driver.findElement(By.xpath("(//H2)[3]")).isDisplayed());

        //6. Ad ve e-posta adresini girin
        // 7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Rana", Keys.TAB,"ranabetul987@gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. 'MUHASEBE BİLGİLERİ' görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//b[.='Enter Account Information']")).isDisplayed());
        //9. Detayları doldur: Başlık, İsim, E-posta, Şifre, Doğum tarihi
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        Thread.sleep(3000);
        WebElement day=driver.findElement(By.cssSelector("#days"));
        day.sendKeys("28");
        WebElement maunth=driver.findElement(By.cssSelector("#months"));
        maunth.sendKeys("May");
        WebElement year=driver.findElement(By.cssSelector("#years"));
        year.sendKeys("2023");

        //10. 'Bültenimize kaydolun!' Onay kutusunu seçin!'
        driver.findElement(By.cssSelector("#newsletter")).click();

        //11. 'Ortaklarımızdan özel teklifler alın!' Onay kutusunu seçin!'
        driver.findElement(By.xpath("(//div[@class='checkbox'])[2]")).click();

        //12. Detayları doldur: Adı, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Mobil Numarası
        driver.findElement(By.cssSelector("#first_name")).sendKeys("Rana",Keys.TAB,"Turkmen",Keys.TAB,"techpro",Keys.TAB,"Kocaeli",Keys.TAB,"İstanbul");
        driver.findElement(By.cssSelector("#country")).sendKeys("Turkey",Keys.TAB,"N",Keys.TAB,"Gebze",Keys.TAB,"Tatlıkuyu",Keys.TAB,"41000",Keys.TAB,"5462454526");

        //13. 'Hesap Oluştur düğmesi'ni tıklayın'
        WebElement submit=driver.findElement(By.xpath("//button[.='Create Account']"));
        submit.click();

        //14. 'TEMEL OLUŞTURULDU!' görünür
        WebElement created=driver.findElement(By.xpath("(//h2)[1]"));
        System.out.println(created.isDisplayed());

        //15. 'Devam' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();

        driver.navigate().back();
        driver.navigate().forward();

        //16. 'Kullanıcı adı olarak oturum aç' ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.cssSelector("i[class='fa fa-user']")).isDisplayed());

        //17. 'Hesabı Sil' düğmesini tıklayın
        // driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        //18. 'ACCOUNT DELETED!' görünür ve 'Devam' düğmesine tıklayın
        // System.out.println(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());

        // driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
    }
}
