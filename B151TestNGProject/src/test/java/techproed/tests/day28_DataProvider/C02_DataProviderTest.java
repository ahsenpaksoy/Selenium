package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {

    /*
    Google sayfasina gidip DataProvider ile belirtilen arac isimlerini aratalim
     */

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"volvo"},{"audi"},{"mercedes"},{"ford"}};
    }

    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        //Google sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //DataProvider'daki verilerle arama yapalim
        GooglePage googlePage = new GooglePage();
        googlePage.cerez.click();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        //googlePage.aramaKutusu.submit();  // Keys.ENTER yeine kullanilir
        ReusableMethods.bekle(3);

        //Her arama icin sayfa resmi alalim sayfayi kapatalim
        ReusableMethods.tumSayfaResmi(araclar);
        ReusableMethods.bekle(2);

        //Sayfayi kapatalim
        Driver.closeDriver();

    }
}
