package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IframeOdev extends TestBase {
    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        bekle(2);

        // sayfadaki toplam iframe sayısını bulunuz.
        driver.findElement(By.xpath("//iframe")).getSize();
        driver.findElements(By.tagName("iframe”"));

        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are : " + iframeElements.size());

        // Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        WebElement sayfaBasligi = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(sayfaBasligi.getText().contains("Editor"));

        // Paragrafdaki yaziyi silelim
        driver.switchTo().frame("mce_0_ifr");

        WebElement text = driver.findElement(By.xpath("//p"));
        text.clear();
        bekle(2);

        // Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        text.sendKeys("iframein icindeyim");
        bekle(2);

        // Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        bekle(2);
        WebElement selenium = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        Assert.assertTrue(selenium.getText().contains("Elemental Selenium"));

    }




}





