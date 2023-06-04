package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Techproeducation sayfasına gidelim
        driver.navigate().to("https://techproeducation.com");  //get() methodu ile ayni seyi yapar
        Thread.sleep(3000); //Java kodlarini bekletmek icin kullaniriz

        //Sonra Amazon sayfasına gidelim
        driver.navigate().to("https://amazon.com");
        Thread.sleep(3000);

        //Amazon sayfasının başlığını yazdıralım
        System.out.println("Amazon Sayfa Basligi : " + driver.getTitle());
        Thread.sleep(3000);

        //Techproeducation sayfasına geri dönelim
        driver.navigate().back();
        Thread.sleep(3000);

        //Sayfa başlığını yazdıralım
        System.out.println("Techproeducation Sayfa Basligi : " + driver.getTitle());
        Thread.sleep(3000);

        //Amazon sayfasına tekrar gidip url'i yazdıralım
        driver.navigate().forward();
        System.out.println("Amazon Sayfasi Url'i : " + driver.getCurrentUrl());
        Thread.sleep(3000);

        //Amazon sayfasındayken sayfayı yenileyelim
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Sayfayi kapatalim
        driver.close();

        /*
          HOMEWORK
            Yeni bir Class olusturalim.C05_NavigationMethods
            Youtube ana sayfasina gidelim . https://www.youtube.com/
            Amazon soyfasina gidelim. https://www.amazon.com/
            Tekrar YouTube’sayfasina donelim
            Yeniden Amazon sayfasina gidelim
            Sayfayi Refresh(yenile) yapalim
            Sayfayi kapatalim / Tum sayfalari kapatalim
         */

    }
}
