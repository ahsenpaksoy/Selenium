package erolHocaTasks;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Task09Team extends TestBase {
    @Test
    public void test01() throws IOException {
        driver.get("https://www.selenium.dev/downloads/");
        bekle(1);

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/TakesScreenshot" + date + ".png"));
        bekle(1);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        bekle(1);

        driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]")).click();
        bekle(1);

        WebElement documantation = driver.findElement(By.xpath("(//*[text()='documentation'])[5]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", documantation);
        bekle(1);

        WebElement resim = driver.findElement(By.xpath("(//*[@class='mYVXT'])[1]"));
        String path = "src/test/java/Screenshot" + date + ".png";
        FileUtils.copyFile(resim.getScreenshotAs(OutputType.FILE), new File(path));
        bekle(1);

        driver.findElement(By.xpath("(//*[@class='C9DxTc '])[17]")).click();
        bekle(1);

        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("1"+sayfa1Handle);

        driver.findElement(By.xpath("(//*[@class='C9DxTc aw5Odc '])[5]")).click();
        bekle(1);

        Set<String> windows = driver.getWindowHandles();
        for (String each: windows) {
            // System.out.println(each);
            if (!each.equals(sayfa1Handle)){
                driver.switchTo().window(each);
            }
        }
        String sayfa2Handle = driver.getWindowHandle();
        System.out.println("2"+sayfa2Handle);
    }
}


     /*

     import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utililities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
public class C01 extends TestBase {
    @Test
    public void test01() throws IOException, InterruptedException {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/testOutput" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);

        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Rana");
        extentHtmlReporter.config().setReportName("ExtentReport");
        extentHtmlReporter.config().setDocumentTitle("Extent Test");

        extentTest = extentReports.createTest("Selenyum test raporu", "Test Raporu");

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        String sayfa1 = driver.getWindowHandle();
        extentTest.info("Sayfaya gidildi.");

        //Sayfanın resmini alalım
        tumSayfaResmi();
        extentTest.info("Sayfanın resmi alındı.");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("(//i[@class='fas fa-plus show-collapsed pe-2'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", browser);

        extentTest.info("Browsers bölümü görünene kadar sayfa indirildi.");

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        js.executeScript("arguments[0].click();", browser);
        Thread.sleep(2000);

       //Documentation webelementinin resmini alalım
        WebElement documentation = driver.findElement(By.xpath("//a[@href='https://chromedriver.chromium.org/']"));
        webElemenResim(documentation);

        extentTest.info("Documentation webelementinin resmi alındı.");

        documentation.click();

        extentTest.info("Chrome driver bölümündeki documentation linkine tıklandı.");

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//a[@href='/downloads'])[4]")).click();//Downloads

        driver.findElement(By.xpath("(//a[@class='XqQF9c'])[4]")).click();//ChromeDriver 114.0.5735.90

        //Açılan pencerede chromedriver'i indirelim
        Set<String> handles = driver.getWindowHandles();
        handles.forEach(t -> {
            if (!t.equals(sayfa1)) {
                driver.switchTo().window(t);
            }
        });
        driver.findElement(By.xpath("//a[@href='/114.0.5735.90/chromedriver_win32.zip']")).click();//chromedriver_win32.zip

        //Driver'in indiğini doğrulayalım
        String yol = "C:/Users/Türkmen/Downloads/chromedriver_win32.zip";

        Thread.sleep(3000);

        Assert.assertTrue(Files.exists(Paths.get(yol)));

        extentTest.info("Driver'in indirildiği doğrulandı.");

        //İndirmiş olduğumuz dosyayı silelim
        Files.delete(Paths.get(yol));
        extentTest.info("Dosya silindi.");

        //Silindiğini doğrulayalım
        Assert.assertFalse(Files.exists(Paths.get(yol)));

        extentTest.info("Silindiği doğrulandı.");
        extentTest.pass("Sayfa kapatıldı.");
        extentReports.flush();

        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
    }
}
      */


   /*

   import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import util.Methods;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Task09 extends Methods {

    ExtentReports extentReports; //raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter; // raporu HTML formatinda duzenler.
    ExtentTest extentTest; // test adimlarina eklemk istedigimiz bilgileri bu class ile olusruruz.
    @Test
    public void task09() throws IOException {

        extentReports = new ExtentReports();
        String raporTarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());
        String raporDosyaYolu = "testOutput/extentReports/extentReport"+raporTarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(raporDosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);// HTML formatinda raporlamayi baslatacak

        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Zulfiye");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Raporu");
        extentTest= extentReports.createTest("ExtentTest","Test Raporu");//test ismi ve aciklamasi

    //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        extentTest.info("Selenium sayfasina gidildi");

    //Sayfanın resmini alalım
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());
        String dosyaYolu = "src/test/java/tumSayfaResmi/selenium"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);
        extentTest.info("Tam sayfa resmi alindi");

    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        extentTest.info("Browser bolumu gorunene kadar sayfa kaydirildi");

    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    WebElement browser =  driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
    wait(2);
        browser.click();
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        extentTest.info("documentation linkine tiklandi");

    //Documentation webelementinin resmini alalım
        WebElement documantation = driver.findElement(By.xpath("(//*[@class='PsKE7e qV4dIc Qrrb5 YSH9J'])[6]"));
        String dosyaYolu1 = "src/test/java/tumSayfaResmi/documantation"+tarih+".png";

        FileUtils.copyFile(documantation.getScreenshotAs(OutputType.FILE),new File(dosyaYolu1));
        extentTest.info("Web elementin resmi alindi");

    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class='C9DxTc '])[17]")).click();
        extentTest.info("Chrome Driver versiyonu secildi");

    //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("(//*[@class='C9DxTc aw5Odc '])[1]")).click();
        Set<String> handles = driver.getWindowHandles();

        String ikinciSayfaHandle = "";
        for (String w : handles ) {
            if(!w.equals(ilkSayfaHandle)){
                ikinciSayfaHandle= w;
                System.out.println("ikinciSayfaHandle = " + ikinciSayfaHandle);
            }
        }

        driver.switchTo().window(ikinciSayfaHandle);
        wait(2);
        extentTest.info("Driver Ikinci sayfaya tasindi");

        WebElement indirme = driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']"));
        indirme.click();
        extentTest.info("Chrome Driver indirme linkine tiklandi");


    //Driver'in indiğini doğrulayalım
        String indirilenDosyaYolu= "C:\\Users\\zulfi\\Downloads\\chromedriver_win32 (1).zip";
        wait(15);
        Assert.assertTrue(Files.exists(Paths.get(indirilenDosyaYolu)));
        extentTest.info("Driver'in indirildigi dogrulandi");

    //İndirmiş olduğumuz dosyayı silelim

        try {
            Files.delete(Paths.get(indirilenDosyaYolu));
        }catch (IOException e){
            System.out.println("dosya bulunamadi");
        }
        extentTest.info("Indirilen dosya silindi");

    //Silindiğini doğrulayalım
        wait(5);
        Assert.assertFalse(Files.exists(Paths.get(indirilenDosyaYolu)));
        extentTest.info("Indirilen dosyanin silindigi dogrulandi");

        driver.close();
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();// bu kodu yazmazsak rapor olusmaz.


    //Not: Bu task'in her adımı için Html rapor oluşturalım(ExtentReport)

    }
}

    */








