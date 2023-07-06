package burak_hoca_maven.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import burak_hoca_maven.utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void TimeOutException() {
        /*
           TimeOutException : Sayfada aradigimiz elementi wait ile belirttigimiz max surede bulamadigi
           durumda TimeOutException hatasi aliriz.
         */

        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(3);

        // reklami kapatiniz
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // searchBox gorunur oluncaya kadar bekleyiniz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")));

        /*
        TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
         */

    }

    @Test
    public void TimeOutExceptionTest2() {

        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorldYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); //bekleme süresi kısa olduğu için hata verir
        wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));
        Assert.assertTrue(helloWorldYazisi.isDisplayed());

        /*
         Gercekte Hello World! yazisi ortalama 6 saniyede gozukuyor
        TimeOutException alabilmek icin Explicit Wait'e max bekleme sureisni 1 saniye verdik.
        Bu sebeple TimeOutException hatasi aldik.
         */

    }





}





