package erolHocaTasks;

import org.junit.Test;
import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class Task09 extends TestBase {
    @Test
    public void test01() {

        //https://www.selenium.dev/downloads/ adresine gidelim
        //Sayfanın resmini alalım
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        //Documentation webelementinin resmini alalım
        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        //Açılan pencerede chromedriver'i indirelim
        //Driver'in indiğini doğrulayalım
        //İndirmiş olduğumuz dosyayı silelim
        //Silindiğini doğrulayalım
        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

        extentReport("Chrome", "Selenium.dev sayfası Testi");
        extentTest = extentReports.createTest("ExtentReport", "Test Raporu");

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        extentTest.info("Selenium.dev sayfasına gidildi");
        bekle(2);

        //Sayfanın resmini alalım
        tumSayfaResmi();
        extentTest.info("Sayfa resmi alındı");
        bekle(2);

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
        jsScrollWE(browser);
        extentTest.info("Browser bölümüne gidildi");
        bekle(2);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        WebElement BrowserLink = driver.findElement(By.xpath("(//*[@class='fas fa-plus show-collapsed pe-2'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();  ", BrowserLink);
        bekle(2);

        //Documentation webelementinin resmini alalım
        WebElement documentation = driver.findElement(By.xpath("//*[@id=\"supported-browsers\"]/div[5]/div/div[2]/div/p/a"));
        webElementResmi(documentation);
        extentTest.info("Oocumentation webelementin resmini aldık");
        bekle(2);

        WebElement chromeDocument = driver.findElement(By.xpath("//*[@id=\"supported-browsers\"]/div[5]/div/div[2]/div/p/a"));
        js.executeScript("arguments[0].click();  ", chromeDocument);
        extentTest.info("Browser bölümünde Chrome driver bölümünndeki documantation linkine tıklandı");
        bekle(2);

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        WebElement download = driver.findElement(By.xpath("//*[@id=\"WDxLfe\"]/ul/li[6]/div[1]/div/a"));
        Actions action = new Actions(driver);
        action.click(download).perform();
        extentTest.info("download'a gittik ");
        bekle(2);

        // Açılan pencerede chromedriver'i indirelim
        WebElement indir = driver.findElement(By.xpath("//*[@id=\"h.e02b498c978340a_87\"]/div/div/p[2]/a"));
        indir.click();
        String sayfa1Handle = driver.getWindowHandle();

        Set<String> windowHandleSeti = driver.getWindowHandles();

        String sayfa2Handle = "";
        for (String each : windowHandleSeti) {
            if (!each.equals(sayfa1Handle)) {
                sayfa2Handle = each;
            }
        }
        driver.switchTo().window(sayfa2Handle);

        WebElement chromedriver = driver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/a"));
        chromedriver.click();
        bekle(8);
        extentTest.info("chromedriver indirdik ");

        //Driver'in indiğini doğrulayalım
        //    "C:\Users\nnexi\Downloads\chromedriver_win32.zip"
        String dosyaYolu = "C:\\Users\\nnexi\\Downloads\\chromedriver_win32.zip";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        extentTest.info("Driver indirdiğimizi doğruladık");

        //Silindiğini doğrulayalım
        File file = new File(dosyaYolu);
        file.delete();
        extentTest.info("Dosyanın silindiğini doğruladık");
        extentReports.flush();

        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    }
}
