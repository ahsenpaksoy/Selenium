package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle extends TestBase {
    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println(sayfa1Handle);
        bekle(2);

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.getText().equals("Opening a new window"));
        bekle(2);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title = driver.getTitle();
        //Assert.assertTrue(title.equals("The Internet"));
        Assert.assertEquals("The Internet",title);
        bekle(2);

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        bekle(2);

        /*
        eger bir butona tıkladıgımızda bizim kontrolumuz dısında 2. sayfa acılıyorsa,
        otomatik acılan 2.sayfa'ya driver'ı gecirmemiz gerekir.
        2.sayfa'ya driver'ı gecirebilmemiz icin 2. sayfa'nın handle degerini bulmalıyız
        getwindowHandles(); methodu sayesinde 2. sayfanın handle degerini tespit edebiliriz.
        daha sonra driver.switchTo().window(sayfa2Handle); diyerek 2. sayfa'ya driver'ı gecirebiliriz
         */

        Set<String> windowHandleSeti = driver.getWindowHandles();
        String sayfa2Handle = "";
        for(String w : windowHandleSeti){
            if(!w.equals(sayfa1Handle)){
                sayfa2Handle = w;
            }
        }
        System.out.println("SAYFA2HANDLE : " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertEquals("New Window", ikinciSayfaTitle);
        bekle(2);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement sayfadakiText = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("New Window",sayfadakiText.getText());
        bekle(2);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(sayfa1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2Handle);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfa1Handle);
        bekle(2);

    }
}

