package practiceMix2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Homework extends TestBase {
    @Test
    public void Test01() {
        // amazona gidin
        driver.get("https://amazon.com");

        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            String op = options.get(i).getText();
            System.out.println(options);
        }

        // dropdown menude 40 eleman olduğunu doğrulayın
        int sizeDropDown = options.size();
        Assert.assertEquals(40,sizeDropDown);
    }

    @Test
    public void Test02() {
        // amazona gidin
        driver.get("https://amazon.com");
        bekle(2);

        // dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");
        bekle(2);

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("iphone", Keys.ENTER);
        bekle(2);
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("Sonuc Yazisi : " + sonucYazisi.getText());
        String sonucSayisi[] = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi : " + sonucSayisi[3]);

        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));

        // ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        //WebElement ikinciUrun = driver.findElement(with(By.tagName("img")).near(ilkUrun));
        WebElement ikinciUrun = driver.findElement(with(By.className("img")).toRightOf(ilkUrun));
        ikinciUrun.click();
        bekle(2);

        // ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String urunTitle = driver.getTitle();
    }

    @Test
    public void Test03() {
        // yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        bekle(2);

        // dropdown’dan bebek bölümünu secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");
        bekle(2);

        // bebek puset aratıp bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("bebek puset", Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi : " + sonucSayisi[2]);
        bekle(2);

        // sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("puset"));

        // üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        WebElement ucuncuUrun = driver.findElement(with(By.tagName("span")).below(ikinciUrun));
        ucuncuUrun.click();

        // title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    }

    @Test
    public void Test04() {
        // sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}

















