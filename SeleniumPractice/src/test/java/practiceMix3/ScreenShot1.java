package practiceMix3;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot1 extends TestBase {
    @Test
    public void test01() throws IOException {
        // Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        String dosyaYolu = "target/TumSayfaResmi/screenShot.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        // “QA” aramasi yap
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("QA", Keys.ENTER);

        // Acilan sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        WebElement text = driver.findElement(By.xpath("//h1[text()='Search Results for: QA']"));
        Assert.assertEquals("Search Results for: QA", text.getText());

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu1 = "target/TumSayfaResmi/screenShot" + tarih + ".png";
        TakesScreenshot ts1 = (TakesScreenshot) driver;
        FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE), new File(dosyaYolu1));

    }

    @Test
    public void test02() throws IOException {
        driver.get("https://amazon.com");
        bekle(2);

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        // Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));  Boyle de alinabilir.
    }

    @Test
    public void test03() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        tumSayfaResmi();
    }
    @Test
    public void test04() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonucun yazisinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_mm_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }






}











