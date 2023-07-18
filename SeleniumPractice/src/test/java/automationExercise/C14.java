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
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class C14 {
    //1. Tarayıcıyı başlatın
    static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
        //4. Sepete ürün ekleyin
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        driver.navigate().back();
        driver.navigate().forward();
        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //6. Sepet sayfasının görüntülendiğini doğrulayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
        String shoppingCart=driver.findElement(By.cssSelector("ol[class='breadcrumb']")).getText();
        Assert.assertEquals(shoppingCart,"Home Shopping Cart");

        //7. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //8. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();
        //9. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Rana", Keys.TAB,"ranabtl97@gmail.com",Keys.ENTER);
        //10. 'HESAP OLUŞTURULDU!'nu doğrulayın! ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        WebElement day=driver.findElement(By.xpath("//select[@id='days']"));
        Select select1=new Select(day);
        select1.selectByVisibleText("28");

        WebElement months=driver.findElement(By.xpath("//select[@id='months']"));
        Select select2=new Select(months);
        select2.selectByVisibleText("May");

        WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
        Select select3=new Select(year);
        select3.selectByVisibleText("1999");

        driver.findElement(By.cssSelector("#first_name")).sendKeys("Rana",Keys.TAB," Türkmen",Keys.TAB,"Techproeducation");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Adrees");

        WebElement country=driver.findElement(By.cssSelector("#country"));
        Select select4=new Select(country);
        select4.selectByIndex(1);

        driver.findElement(By.cssSelector("#state")).sendKeys("state",Keys.TAB,"city",Keys.TAB,"zipcode",Keys.TAB,"5555555555",Keys.ENTER);

        //11. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        String verify=driver.findElement(By.xpath("//b[.='Account Created!']")).getText();
        Assert.assertEquals(verify,"ACCOUNT CREATED!");
        //12.'Sepet' düğmesine tıklayın

        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        //13. 'Ödeme İşlemine Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='checkout-information']")).isDisplayed());

        //15. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Sevgiler",Keys.TAB,Keys.ENTER);

        //16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        //17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Rana Betül Türkmen",Keys.TAB,"5282080029365764",Keys.TAB,"698",Keys.TAB,"11",Keys.TAB,"2028",Keys.TAB,Keys.ENTER);

        //18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        Assert.assertEquals(driver.findElement(By.xpath("//h2//b")).getText(),"ORDER PLACED!");

        //19. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

        //20. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        String silindi=driver.findElement(By.xpath("//h2//b")).getText();
        Assert.assertEquals(silindi,"ACCOUNT DELETED!");

    }

}