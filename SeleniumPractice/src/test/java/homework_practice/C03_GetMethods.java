package homework_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class C03_GetMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //Sayfa basligini(title) yazdirin
        System.out.println("Title : " + driver.getTitle());

        //Sayfa basliginin “Amazon” icerdigini test edin
        String actlTitle = driver.getTitle();
        String expctdTitle = "Amazon";
        if(actlTitle.contains("Amazon")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Sayfa adresini(url) yazdirin
        System.out.println("Url : " + driver.getCurrentUrl());

        //Sayfa url’inin “amazon” icerdigini test edin.
        String actlUrl = driver.getCurrentUrl();
        String expctdUrl = "amazon";
        if(actlUrl.contains(expctdUrl)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // Sayfa handle degerini yazdirin
        System.out.println("Handle Degeri : " + driver.getWindowHandle());

        //Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String actlPageSource = driver.getPageSource();
        String expctdPageSource = "Gateway";
        if(actlPageSource.contains(expctdPageSource)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Sayfayi kapatin.
        driver.close();



    }
}










