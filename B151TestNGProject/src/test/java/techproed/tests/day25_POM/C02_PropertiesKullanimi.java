package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PropertiesKullanimi {
    @Test
    public void amazonTest() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        /*
        Cok fazla amazon sayfasina gittigimizi dusunelim ve amazon url'inde bir degisiklik
        oldugunda butun testlerden url'i duzeltmek yerine sadece .properties dosyasindan duzelterek
        tum testlerdeki url'i duzeltmis oluruz.
         */
    }
}
