package day02_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class AmazonSearchTest1 extends TestBase {
    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        // “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);

        // Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi));
        System.out.println("Sonuc sayisi : " + sonucSayisi[2]);

        // Ilk urunu tiklayalim
        //driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        // Sayfadaki tum basliklari yazdiralim
        List<WebElement> basliklar = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        for (int i = 0; i < basliklar.size(); i++) {
            basliklar = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            basliklar.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }

        }
    }

