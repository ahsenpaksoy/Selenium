package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest1 {
    /*
     Bir class'da listeners kullanabilmek için class'dan önce @Listeners notasyonu eklememiz gerekir.
Ve bu notasyon içine oluşturduğumuz Listeners class'ının yolunu parametre olarak eklemeliyiz.
     */

    @Test(invocationCount = 10,successPercentage = 90) //testi 10 kere calistir,%90 lik basari ver
    /*
    @Test notasyonundan sonra parametre olarak invocationCount = 10 eklersek belirttiğimiz sayı kadar
testlerimizi çalıştırır. successPercentage = 90 bu parametre ise yüzdelik belirtir yani ikisi bir arada
kullanılırsa 10 testten 1 tanesi çalışmaz ise sorun olmaz ama 2 tanesi çalışmaz ise
onTestFailedButWithinSuccessPercentage() methodu devreye girer.
     */
    public void test01() {
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }

    @Test
    public void test02() {
        System.out.println("FAILED");
        Assert.assertTrue(false);
    }

    @Test
    public void test03() {
        System.out.println("SKIP");
        throw new SkipException("Bu method atlandı");
    }

    @Test
    public void test04() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().findElement(By.id("lkhjlkjhlj")).click();
    }
}







