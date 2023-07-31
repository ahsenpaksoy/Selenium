package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class C03_ListenersTest3 {
    /*
        Eğer Testimizin başarısız(fail) olma durumunda tekrar çalışmasını istersek,
     @Test notasyonundan sonra retryAnalyzer parametresi ile listeners class'ının yolunu belirtiriz.
     Bununla birlikte ITestListeners arayüzündeki methodlarıda kullanabilmek için yine class'dan önce
     @Listeners notasyonu kullanırız.
     */

     /*
        Eğer fail olan testlerimizi otomatik olarak belirttiğimiz sayı kadar çalıştırmak istersek
    listeners class'ınındaki retry ve transform methodları sayesinde çalıştırabiliriz. Bunun için
    çalıştırmak istediğimiz test methodunun notasyonundan sonra parametre olarak;
    retryAnalyzer parametresini kullanarak listeners classının yolunu belirtiriz.
     */

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void amazonTest() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().findElement(By.id("lkhjlkjhlj")).click();
    }

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void techproTest() {
        Driver.getDriver().get("https://techproeducation.com");
        Driver.getDriver().findElement(By.id("lkhjlkjhlj")).click();
    }
}
//@Listeners(techproed.utilities.Listeners.class)
// Bunu ekleyince fail olunca 1 kez daha calisir ve ITestListener methodlarini kullanir.
