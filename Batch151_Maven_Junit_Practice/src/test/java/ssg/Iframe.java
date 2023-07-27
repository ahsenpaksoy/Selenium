package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Iframe extends TestBase {
    @Test
    public void iframeTest01() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement baslik = driver.findElement(By.tagName("h3"));
        System.out.println(baslik.getText());

        driver.switchTo().frame("mce_0_ifr");

        WebElement metinAlani = driver.findElement(By.tagName("p"));
        metinAlani.clear();
        bekle(2);
        metinAlani.sendKeys("Gürkay Birinci");

        driver.switchTo().parentFrame();

        System.out.println(baslik.getText());
        bekle(2);
    }

    @Test
    public void iframeTest02() {
        driver.get("https://demoqa.com/nestedframes");
        WebElement baslik = driver.findElement(By.className("main-header"));
        System.out.println(baslik.getText());
        WebElement iframe01 = driver.findElement(By.xpath("//iframe[@src='/sampleiframe']"));
        driver.switchTo().frame(iframe01);
        WebElement metin1 = driver.findElement(By.tagName("body"));
        System.out.println(metin1.getText());
        driver.switchTo().frame(0);
        WebElement metin2 = driver.findElement(By.tagName("body"));
        System.out.println(metin2.getText());
        driver.switchTo().defaultContent();
        System.out.println(baslik.getText());

    }


}
