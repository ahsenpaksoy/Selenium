package burak_hoca_selenium.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebElementLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // aramakutusunu locate ediniz ve Nutella aratınız
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        /*
           Eger bir webelement'i birden fazla kez kullanmayacaksaniz bir webelement'e assign etmeyebilirsiniz.
         */

        Thread.sleep(2000);

        //farklı yol 2 :
        //WebElement aramaTiklama = driver.findElement(By.id("nav-search-submit-button"));
        //aramaTiklama.click();

        // sayfayı kapatınız
        driver.close();



    }
}
