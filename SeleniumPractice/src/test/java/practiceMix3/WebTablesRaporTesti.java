package practiceMix3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class WebTablesRaporTesti extends TestBase {
    @Test
    public void test01() {

        extentReport("Chrome","ReportOfReport");
        extentTest = extentReports.createTest("ExtentTest","Test Raporu");

        // C03_WebTables class'ı için aldığımız rapora gidelim
        // NOT : driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")
        driver.get("testOutput/extentReports/extentReport_08_53_38_26062023.html");
        extentTest.info("Rapora gidildi.");
        bekle(2);

        // Başlığın Extent Report olduğunu test edelim
        Assert.assertEquals("Extent Report",driver.getTitle());
        extentTest.info("Basligin Extent Report oldugu test edildi.");
        bekle(2);

        // Rapor temasını dark yapalım
        driver.findElement(By.xpath("//*[@id='theme-selector']")).click();
        extentTest.info("Rapor temasi dark yapildi.");
        bekle(2);

        //Tum Sayfanin Ekran Goruntusunu Alin
        tumSayfaResmi(); //---> TestBase'den method
        extentTest.info("Tum Sayfa ekran görüntüsü alindi");
        bekle(2);

        // Dashboard bölümüne gidip tabloyu yazdırınız
        driver.findElement(By.xpath("(//*[@class='material-icons'])[3]")).click();
        bekle(2);
        WebElement tablo = driver.findElement(By.xpath("(//tbody)[3]"));
        System.out.println("Tablo = " + tablo.getText());
        extentTest.info("tablo yazdirildi");
        bekle(2);

        // Tester'ın "isminiz" olduğunu doğrulayalım
        driver.findElement(By.xpath("//*[@class='waves-effect active']")).click();
        bekle(2);
        WebElement tester = driver.findElement(By.xpath("//*[text()='Ahsen']"));
        Assert.assertTrue(tester.getText().contains("Ahsen"));
        extentTest.info("Tester ismi doğrulandi");
        bekle(1);

        // Sayfayı kapatalım
        driver.quit();
        extentTest.pass("Sayfa Kapatıldı");
        extentReports.flush();
    }


}








