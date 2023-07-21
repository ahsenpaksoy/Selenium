package tests.practicePdf;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_4 {

    @Test
    public void test01() {

        //Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(2);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("gecersizMail"));
        ReusableMethods.waitFor(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("blueRentalpassword"), Keys.ENTER);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(blueRentalCarPage.invalidEmail.isDisplayed());

    }

    @Test
    public void test02() {

        //Dogru email uzantisi girildiğinde hata mesajı alınmamalı
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(2);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalMail"));
        ReusableMethods.waitFor(2);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("blueRentalpassword"), Keys.ENTER);
        ReusableMethods.waitFor(2);

        blueRentalCarPage.loginVerify.click();
        Assert.assertTrue(blueRentalCarPage.reservations.isDisplayed());

    }
}






















