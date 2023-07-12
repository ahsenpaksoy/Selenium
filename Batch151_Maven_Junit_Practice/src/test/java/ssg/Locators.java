package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Locators extends TestBase {
    @Test
    public void locatorsTesti() {

        // https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");

        // “En Çok Satılanlar” bölümündeki ilk ürünü seçiniz.
        List<WebElement> enCokSatilanlarListesi = driver.findElements(By.className("bestseller-item"));
        String ilkKitap = enCokSatilanlarListesi.get(0).getText().split("\n")[0];
        enCokSatilanlarListesi.get(0).click();

        // Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
        WebElement kitapAdi = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(ilkKitap,kitapAdi.getText());

        // "Devamını Oku…" butonuna basınız.
        WebElement devaminiOku = driver.findElement(By.partialLinkText("Devamı"));
        devaminiOku.click();

        // Ürünü sepete ekleyiniz.
        WebElement sepeteEkle = driver.findElement(By.linkText("Sepete Ekle"));
        //WebElement sepeteEkle = driver.findElement(By.id("button-cart"));
        sepeteEkle.click();

        // Sepete gidiniz.
        WebElement sepeteGit = driver.findElement(By.linkText("sepetinize"));
        sepeteGit.click();

        // Ürüne ait kontrol kutusunu işaretleyiniz.
        WebElement urunKontrolKutusu = driver.findElement(By.name("cart_selection[]"));
        Assert.assertFalse(urunKontrolKutusu.isSelected());

        if (!urunKontrolKutusu.isSelected()){
            urunKontrolKutusu.click();
        }

        // Ürün miktarını değiştiriniz.
        WebElement urunMiktari = driver.findElement(By.name("quantity"));
        Assert.assertEquals("1", urunMiktari.getAttribute("value"));
        urunMiktari.clear();
        urunMiktari.sendKeys("3");
        Assert.assertEquals("3", urunMiktari.getAttribute("value"));
    }

}





















