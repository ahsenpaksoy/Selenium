package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IframeTest extends TestBase {
    @Test
    public void iframeTest() {

        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        bekle(2);

        // Bir metod olusturun: iframeTest
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda  yazdirin
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isEnabled());
        System.out.println(text.getText());

        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();
        textbox.sendKeys("Merhaba Dunya");
        bekle(2);

        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
        // oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        bekle(2);
        WebElement selenium = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(selenium.isDisplayed());
        System.out.println(selenium.getText());


    }
}
