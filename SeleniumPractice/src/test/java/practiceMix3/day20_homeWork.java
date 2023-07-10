package practiceMix3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class day20_homeWork extends TestBase {
    @Test
    public void test01() {

        //ÖDEV
        extentReport("Chrome","Raporun Raporu");
        extentTest = extentReports.createTest("ExtentTest", "test raporu");

        //C01_WebTables class'ı için aldığımız rapora gidelim
        driver.get("C:\\Users\\Sinem\\SeleniumTechPro\\Batch151MavenJUnit\\testOutput\\extentReports\\extentReport_06_01_58_10072023.html"); // adres degisecek
        extentTest.info("Rapora gidildi...");

        //Başlığın Extent Report olduğunu test edelim
        Assert.assertEquals("Extent Report", driver.getTitle());
        extentTest.info("Başlığın Extent Report olduğu test edildi");

        //Rapor temasını dark yapalım
        driver.findElement(By.id("theme-selector")).click();
        extentTest.info("Rapor temasi dark yapildi");

        //Dashboard bölümüne gidip tabloyu yazdırınız
        driver.findElement(By.xpath("//*[@class='waves-effect']")).click();
        WebElement table = driver.findElement(By.xpath("(//table)[3]"));
        System.out.println(table.getText());
        extentTest.info("dashboard bolumundeki tablo yazdirildi.");

        //Tester'ın "Ahsen" olduğunu doğrulayalım
        String actualData = driver.findElement(By.xpath("(//table)[3]//tr[3]//td[2]")).getText();
        String expectedData = "Ahsen";
        Assert.assertEquals(expectedData,actualData);
        extentTest.info("Tester'ın Ahsen olduğu doğrulandi.");

        //Sayfayı kapatalım
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();

    }
}
