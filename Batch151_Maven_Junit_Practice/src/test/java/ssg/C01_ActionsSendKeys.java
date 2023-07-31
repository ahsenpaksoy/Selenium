package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_ActionsSendKeys extends TestBase {

    // Klavye Actions

    // sendKeys ==> Bir yazı gönderilirken yada bir tusa bir kez basacaksak kullanılır.
    // sendKeys(Keys.TAB)
    // sendKeys(Keys.PAGE_DOWN)

    // keyDown ==> Bir tusa basılı tutacaksak kullanılır.
    // keyDown(Keys.SHIFT)

    // keyUp ==> Tusu kaldıracaksak kullanılır.
    // keyUp(Keys.SHIFT)


    // Mause Actions

    // click() ==> sol click yapmak icin kullanılır.
    // contextClick() ==> sag click yapmak icin kullanılır.
    // doubleClick() ==> cift tıklamak icin kullanılır.
    // clickAndHold() ==> tıkla basılı tut islemi icin kullanılır.
    // dragAndDrop() ==> sürükle bırak islemi icin kullanılır.
    // moveToElement() ==> yaklasma islemi icin kullanılır.



    // https://www.gmibank.com/ sayfasına gidiniz
    // "Book Now" yazıları gorunecek kadar sayfayı asagıya kaydırınız.
    // Ortadaki "Book Now" kısmına tıklayınız.
    // url'in "services" icerdigini test ediniz.

    @Test
    public void test01() throws InterruptedException {

        // https://www.gmibank.com/ sayfasına gidiniz
        driver.get("https://www.gmibank.com/");

        // "Book Now" yazıları gorunecek kadar sayfayı asagıya kaydırınız.
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(4000);

        // Ortadaki "Book Now" kısmına tıklayınız.
        driver.findElement(By.xpath("(//a[text()='Book Now'])[2]")).click();


        // url'in "services" icerdigini test ediniz.
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("services"));
    }
}

    // Klavye Actions

    // sendKeys ==> Bir yazı gönderilirken yada bir tusa bir kez basacaksak kullanılır.
    // sendKeys(Keys.TAB)
    // sendKeys(Keys.PAGE_DOWN)

    // keyDown ==> Bir tusa basılı tutacaksak kullanılır.
    // keyDown(Keys.SHIFT)

    // keyUp ==> Tusu kaldıracaksak kullanılır.
    // keyUp(Keys.SHIFT)


    // Mause Actions

    // click() ==> sol click yapmak icin kullanılır.
    // contextClick() ==> sag click yapmak icin kullanılır.
    // doubleClick() ==> cift tıklamak icin kullanılır.
    // clickAndHold() ==> tıkla basılı tut islemi icin kullanılır.
    // dragAndDrop() ==> sürükle bırak islemi icin kullanılır.
    // moveToElement() ==> yaklasma islemi icin kullanılır.









