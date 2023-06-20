package burak_hoca_maven.day16_Wait;

import burak_hoca_maven.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;

public class C03_FluentWait extends TestBase {

        // Fluent Wait ==> Belirli bir kosul gerceklesene kadar max sure boyunca,
        // belittigimiz aralıklarla webelementi kontrol ederek bekler.

        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        //==> Start buttonuna tıklayın
        //==> Hello World! yazısının görünürlügünü test edin

    @Test
    public void fluentWait() {

        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //==> Hello World! yazısının görünürlügünü test edin

        WebElement helloWorldYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)). // Fluent wait icin max bekleme süresi
                        pollingEvery(Duration.ofSeconds(3)). // her 3 sn'de bir webelementi kontrol eder
                        withMessage("Ignore Exception");  // zorunlu degil. hata durumunda msj vermek icin kullanılır.

        wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));

        Assert.assertTrue(helloWorldYazisi.isDisplayed());

        /*
        Thread.Sleep(): Javadan gelir. Belirttigimiz süre kadar kodları bekletir.

        Implictly Wait: Selenium'dan gelir. Sayfadaki tüm webelementlerin yüklenebilmesi icin max. bekleme süresidir.

        Explict Wait 2'ye ayrılır

        1-) WebDriver Wait: Belirli bir koşul gerceklesene kadar max sure boyunca,
            default olarak 500ms aralıklarla webelementi kontrol ederek bekler.

        2-) Fluent Wait: Belirli bir kosul gerceklesene kadar max sure boyunca,
            belirttigimiz aralıklarla webelementi kontrol ederek bekler.

         */

    }
}