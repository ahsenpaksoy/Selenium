package tests.day01;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Priority extends TestBase {

    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz
    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız

    @Test
    public void amazon() {
        driver.get("https://www.amazon.com");
    }
    @Test(priority = 3)
    public void bestbuy() {
        driver.get("www.https://bestbuy.com");
    }
    @Test(priority = -5)
    public void techproeducation() {
        driver.get("https://www.techproeducation.com");
    }

    /*
    TestNG, test methodlarini isim sirasina gore calistirir. Eger isim siralamasinin disinda
    bir siralama ile calistirmak isterseniz o zaman test methodlarine oncelik(priority) tanimlayabiliriz.
    priority kucukten buyuge gore calisir. Eger bir test methoduna priority degeri atanmamissa default
    olarak priority=0 kabul edilir.
     */

}
