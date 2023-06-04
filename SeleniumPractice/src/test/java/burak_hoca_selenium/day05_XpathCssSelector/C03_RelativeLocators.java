package burak_hoca_selenium.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_RelativeLocators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*
          Relative Locators

    - Bir web elementi direk locate edemedigimiz durumlarda,
    o web elementi etrafındaki web elementlerin refaransi ile tarif etmemizi saglar

    - Bir web sayfasında benzer özellikler sahip webelementlerin oldugu durumlarda kullanılabilir

    - above==> Belirtilen elementin üstünde olan elementi secer
    - below==> Belirtilen elementin altında olan elementi secer
    - to_left_of==> Belirtilen elementin solunda olan elementi secer
    - to_right_of==> Belirtilen elementin sagında olan elementi secer
    - near==> Belirtilen elementin yanında/yakınında olan elementi secer
         */

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //city bike aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);

        //Relative Locator kullanarak Hybrid Bikes üstündeki Road Bikes'a tıklayalım
        WebElement hybridBikes = driver.findElement(By.xpath("//span[text()='Hybrid Bikes']"));
        WebElement roadBikes = driver.findElement(with(By.tagName("span")).above(hybridBikes));
        roadBikes.click();

        // sayfayı kapatın
        driver.close();


    }
}
