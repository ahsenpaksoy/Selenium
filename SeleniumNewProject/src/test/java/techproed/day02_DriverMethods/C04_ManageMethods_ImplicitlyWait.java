package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageMethods_ImplicitlyWait {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*
         implicitlyWait(Duration.ofSeconds(20)) Sayfadaki webElementleri görünür olana kadar(sayfada oluşana kadar)
         maximum 20 saniye bekler. Eğer webelementler 2 saniyede oluşursa 2 saniye bekler ve alt satıra geçer. Fakat
         belirttiğimiz max. süre boyunca internetten yada sayfadan kaynaklı olarak webelementler oluşmazsa testimiz
         fail verir.
           Thread.sleep() java kodlarını bizim belirttiğimiz süre kadar bekler. 30 saniye beklemesini belirtirsem
         30 saniye bekler ve alt satıra geçer.
         */

        //techproed sayfasina gidelim
        String amazonUrl = "https://amazon.com";
        String techproUrl = "https://techproeducation.com";
        driver.get(techproUrl);

        //amazona gidelim
        driver.get(amazonUrl);

        //techpro sayfasina geri donelim
        driver.navigate().back();

        //sayfa basliginin Techpro icerdigini test edelim
        String actualTitle = driver.getTitle();
        String arananKelime = "Techpro";
        if(actualTitle.contains(arananKelime)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED ->" + actualTitle);

        //tekrar amazon sayfasina gidelim
        driver.navigate().forward();

        //sayfa basliginin Amazon icerdigini test edelim
        if(driver.getTitle().contains("Amazon")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Sayfayi kapatiniz
        driver.close();


        /*
         HOMEWORK
            Yeni bir Class olusturalim.C07_ManageWindowSet
            Amazon soyfasina gidelim. https://www.amazon.com/
            Sayfanin konumunu ve boyutlarini yazdirin
            Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
            Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
            8. Sayfayi kapatin


            Yeni bir class olusturalim (Homework)
            ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
            oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
            Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
            yazdirin.
            https://www.walmart.com/ sayfasina gidin.
            Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
            Tekrar “facebook” sayfasina donun
            Sayfayi yenileyin
            Sayfayi tam sayfa (maximize) yapin  9.Browser’i kapatin

            Yeni bir class olusturun (TekrarTesti)
            Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
            Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
            Daha sonra Amazon sayfasina gidin https://www.amazon.com/
            Youtube sayfasina geri donun
            Sayfayi yenileyin
            Amazon sayfasina donun
            Sayfayi tamsayfa yapin
            Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
            Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
            URL'yi yazdırın
            Sayfayi kapatin


         */


    }
}
