package tests.day03;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HerokuapPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    // https://id.heroku.com/login sayfasına gidin
    // yanlıs email ve yanlıs password giriniz
    // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)
    // login butonuna tıklayınız
    // "There was a problem with your login." yazisinin gorunur oldugunu test edin
    // sayfayı kapatınız


    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciBilgileri = {{ConfigReader.getProperty("emailYanlis1"),ConfigReader.getProperty("passwordYanlis1")},
                {ConfigReader.getProperty("emailYanlis2"),ConfigReader.getProperty("passwordYanlis2")},
                {ConfigReader.getProperty("emailYanlis3"),ConfigReader.getProperty("passwordYanlis3")}};

        return kullaniciBilgileri ;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void NegatifLoginDataProvider(String email,String password) {

        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuapUrl"));

        // yanlıs email ve yanlıs password giriniz
        // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)
        HerokuapPage herokuapPage = new HerokuapPage();
        herokuapPage.cookies.click();
        herokuapPage.emailKutusu.sendKeys(email);
        herokuapPage.passwordKutusu.sendKeys(password);

        // login butonuna tıklayınız
        herokuapPage.logInButonu.click();

        // "There was a problem with your login." yazisinin gorunur oldugunu test edin
        Assert.assertTrue(herokuapPage.TheWasaProblemYaziElementi.isDisplayed());

        // sayfayı kapatınız
        Driver.closeDriver();


    }
}








