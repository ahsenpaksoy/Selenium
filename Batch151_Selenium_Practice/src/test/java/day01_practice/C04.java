package day01_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // "https://teknosa.com/" adresine gidiniz
        driver.get("https://teknosa.com/");
        Thread.sleep(2000);

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        System.out.println("Page Title : " + driver.getTitle());
        System.out.println("Page Url : " + driver.getCurrentUrl());

        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        if(driver.getTitle().contains("Teknoloji")){
            System.out.println("Title contains technology");
        }else System.out.println("Title does not contain technology");

        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        if(driver.getCurrentUrl().contains("teknosa")){
            System.out.println("Url contains teknosa");
        }else System.out.println("Url does not contain teknosa");

        // "https://medunna.com/" adresine gidiniz
        Thread.sleep(1000);
        driver.get("https://medunna.com/");

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        System.out.println("Medunna Page Title : " + driver.getTitle());
        System.out.println("Medunna Page Url : " + driver.getCurrentUrl());

        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        if(driver.getTitle().contains("MEDUNNA")){
            
        }

        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        // teknosa adresine geri donunuz
        // Sayfayı yenileyiniz
        // medunna adresine ilerleyiniz
        // Sayfayı yenileyiniz
        // pencereyi kapat

        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        if (driver.getTitle().contains("Teknoloji")){
            System.out.println("pages contains technology");
        }else {
            System.out.println("pages does not contain technology");
        }

        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        if (driver.getCurrentUrl().contains("teknosa")){
            System.out.println("Pages contains teknosa");
        }else {
            System.out.println("pages does not contain teknosa");
        }

        // "https://medunna.com/" adresine gidiniz
        Thread.sleep(1000);
        driver.get("https://medunna.com/");

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        System.out.println("Meduna pages tittle: "+driver.getTitle());
        System.out.println("Medunna pages URL: "+driver.getCurrentUrl());

        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        if(driver.getTitle().contains("Medunaa")){
            System.out.println("Meduna pages contains Medunna");
        }else {
            System.out.println("Medunna does not contains Medunna");
        }

        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        if (driver.getCurrentUrl().contains("medunna")){
            System.out.println("Medunna pages contains Medunna");
        }else {
            System.out.println("Medunna does not contains Medunna");
        }

        // teknosa adresine geri donunuz
        Thread.sleep(1000);
        driver.navigate().back();

        // Sayfayı yenileyiniz
        Thread.sleep(1000);
        driver.navigate().refresh();

        // medunna adresine ilerleyiniz
        Thread.sleep(1000);
        driver.navigate().forward();

        // Sayfayı yenileyiniz
        Thread.sleep(1000);
        driver.navigate().refresh();

        // pencereyi kapat
        Thread.sleep(1000);
        driver.close();



    }
}
