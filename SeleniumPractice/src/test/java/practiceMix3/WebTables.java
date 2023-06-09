package practiceMix3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {

    @Test
    public void test01() {

        extentReport("Chrome","WebTable");
        extentTest = extentReports.createTest("WebTable","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi.");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 yazdirildi.");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("***************************************");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3. satir verileri yazdirildi.");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        System.out.println("1. Tablo Son Satir Bilgileri : "+sonSatir.getText());
        extentTest.info("Son satir verileri yazdirildi.");

        //    Task 4 : 5. Sütun verilerini yazdırın
        WebElement besinciBaslik = driver.findElement(By.xpath("///thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText());
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5. Sütun verileri yazdırıldı");

        //    Task 5 : 3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız
        System.out.println("****************************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2"));
        ucuncuSatirr.forEach(t-> System.out.println(t.getText()+"\t"));
        extentTest.info("3. Satırdaki 1. ve 2. sütun bilgilerini yazdırıldı");

        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        System.out.println();
        //WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));
        printData(2,3);
        extentTest.info("2. satir 3 sütun bilgileri yazdırıldı");

        //3. satir 2. sütun bilgisinin Jack olup olmadığını doğrulayın
        printData(3,2);
        String actualData = printData(3,2);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3. satir 2. Sütun bilgisinin Jason olduğu görüldü");
        extentTest.pass("Sayfa kapatildi.");
        extentReports.flush();

    }

    private String printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        return satirSutun.getText();
    }

}











