package burak_hoca_maven.day22_JSExecuter;

import burak_hoca_maven.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JSExecuter_Type extends TestBase {
    @Test
    public void typeTest() {
        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // reklemi kapat
        bekle(4);

        // Arama kutusuna "QA" yazıp aratın

        //1. YOL
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        //aramaKutusu.sendKeys("QA");  // calismadiginda, kodlar JS ile yazildiginda js executer kullaniriz

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].value='QA'",aramaKutusu);
        sendKeysJS(aramaKutusu,"QA");
        aramaKutusu.submit();

        /*
        // 2.YOL
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
        // QA degerini HTML kodu olan value'ya atadi.

        sendAttributeJS(aramaKutusu,"QA");

         */


    }
}
