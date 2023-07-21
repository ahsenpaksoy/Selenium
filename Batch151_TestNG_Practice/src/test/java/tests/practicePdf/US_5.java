package tests.practicePdf;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_5 {
    @Test
    public void test01() {

        // Geçerli giriş yapmadan rezervasyon yapamamalı
        // Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
        // Ve giris yapilmadiginda
        // Hata mesaji almali : Please first login
        // Giris   yapildiginda hata mesaji alınmamalı

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.bekle(2);

        BlueRentalCarPage carPage = new BlueRentalCarPage();
        Select select = new Select(carPage.ddm);
        select.selectByVisibleText(ConfigReader.getProperty("aracMarkasi"));

        carPage.pickLocation.sendKeys(ConfigReader.getProperty("pickUpLocation"), Keys.TAB,
                ConfigReader.getProperty("DropOffLocation"),Keys.TAB, ConfigReader.getProperty("pickUpDate"),
                Keys.TAB, ConfigReader.getProperty("pickUpTime"), Keys.TAB, ConfigReader.getProperty("dropOffDate"),
                Keys.TAB, ConfigReader.getProperty("dropOffTime"), Keys.TAB, Keys.ENTER);
        ReusableMethods.bekle(2);

        Assert.assertTrue(carPage.verifyson.isDisplayed());

        //Sayfayi kapatiniz
        Driver.closeDriver();

    }
}
