package tests.day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_PageClassKullanimi {
    @Test
    public void test01() throws IOException {

        // amazon sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // dropdown'dan "Computers" optionunu secin
        AmazonPage amazonPage = new AmazonPage();
        Select select = new Select(amazonPage.ddm);
        select.selectByVisibleText("Computers");

        // arama motoruna "Asus" yazıp aratın
        amazonPage.aramaKutusu.sendKeys("Asus" + Keys.ENTER);

        // ikinci urunun fotografını cekin
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);


        File kayit = new File("target/ekranGoruntusu/kayit"+tarih+".Jpeg");  // kaydedecegi yer
        File gecici = amazonPage.ikinciUrun.getScreenshotAs(OutputType.FILE); // gecici olarak kaydettik
        FileUtils.copyFile(gecici,kayit); // gecicidekini kayit'a kaydettik

        // ikinci urune tıklayın
        amazonPage.ikinciUrun.click();

        // title'ının "ASUS" icerdigini test edin
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("ASUS"));

        // sayfayı kapatın
        Driver.closeDriver();

    }

}











