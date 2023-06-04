package homework_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods_Mix {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromedriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://facebook.com");
        Thread.sleep(2000);
        String actlTitle = driver.getTitle();
        String expctdTitle = "facebook";
        if(actlTitle.equals(expctdTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -> " + actlTitle);

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actlUrl = driver.getCurrentUrl();
        String expctdUrl = "facebook";
        if(actlUrl.contains(expctdUrl)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -> " + actlUrl);

        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");
        Thread.sleep(2000);

        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "Walmart.com";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -> " + actualTitle);

        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        Thread.sleep(2000);

        //Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //Browser’i kapatin
        driver.close();


    }
}
