package burak_hoca_maven.day16_Wait;

import burak_hoca_maven.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class C04_ExplicitWait extends TestBase {


        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        //==>  Remove tuşuna basın
        //==>  "It's gone!" yazısının görünür oldugunu test edin.

    @Test
    public void test01() {

        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //==>  Remove tuşuna basın
        WebElement remove = driver.findElement(By.xpath("//button[text()='Remove']"));
        remove.click();

        //==>  "It's gone!" yazısının görünür oldugunu test edin.

        WebElement itsGoneYazisi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));

        Assert.assertTrue(itsGoneYazisi.isDisplayed());
        // Implictly wait İLE ASSERTİON YAPABİLDİK. DOLAYISIYLA DİGER WAİT'LERE GEREK KALMADI.

    }
}