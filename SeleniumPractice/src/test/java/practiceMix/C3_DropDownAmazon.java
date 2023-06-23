package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class C3_DropDownAmazon extends TestBase {
    @Test
    public void test01() {

        // https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        bekle(2);

       // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45  oldugunu test edin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);

        List<WebElement> ddmAll = select.getOptions();
        int actualElement = ddmAll.size();
        int expectedElement = 45;
        Assert.assertEquals(expectedElement,actualElement);

    }

    @Test
    public void test02() {
        // https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        bekle(2);

        //Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");
        bekle(2);

        // Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);
        bekle(2);

        // Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi));
        System.out.println("Sonuc Sayisi : " + sonucSayisi[3]);

        // Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("Java"));

    }
}





