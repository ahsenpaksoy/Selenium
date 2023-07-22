package tests.day03;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {

    // amazon sayfasına gidelim
    // Nutella, Java, cigdem ve Netherlands icin arama yapalım
    // sonucların aradıgımız kelime icerdigini test edelim
    // sayfayı kapatalım


    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"Nutella"},
                               {"Java"},
                                {"cigdem"},
                                {"Netherlands"}};

        /*
         Object[][] arananKelimeArrayi = {{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};

        return arananKelimeArrayi;
    }
         */

    }

    //DataProvider=Veri saglayici

    @Test(dataProvider = "aranacakKelimeler")
    //veri saglayicisi demek. Arayacagimiz kelimeleri bir liste gibi tutup bana yollayacak bir veri
    //saglayicisi olusturduk.
    public void test01(String arananKelime) {

        // amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella, Java, cigdem ve Netherlands icin arama yapalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        // sonucların aradıgımız kelime icerdigini test edelim
        String expectedKelime = arananKelime;
        String actualSonucYazisi = amazonPage.sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        // sayfayı kapatalım
        Driver.closeDriver();


    }

}

   /*

     @DataProvider
public static Object[][] kelimeler() {
    return new Object[][]{{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};
}
//DataProvider=Veri saglayici

@Test(dataProvider = "kelimeler")
public void test01(String kelimeler) {
    extentTest = extentReports.createTest("Yunus AYDOGDU","Amazonu test edebilmeli");

    // amazon sayfasına gidelim
    Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    extentTest.info("amazona gidildi");

    // Nutella, Java, cigdem ve Netherlands icin arama yapalım
    AmazonPage amazonPage = new AmazonPage();
    amazonPage.amaraKutusu.sendKeys(kelimeler, Keys.ENTER);
    extentTest.info("aranacak kelimeler girildi");

    // sonucların aradıgımız kelime icerdigini test edelim
    Assert.assertTrue(amazonPage.sonucYazisi.getText().contains(kelimeler));
    extentTest.info("kelimeler test edildi");

    // sayfayı kapatalım
    Driver.closeDriver();
    extentTest.info("sayfalar kapatildi");
    extentReports.flush();
    */





















