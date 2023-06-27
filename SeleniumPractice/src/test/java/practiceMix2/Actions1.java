package practiceMix2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Actions1 extends TestBase {
    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        bekle(2);

        // Kutuya sag tıklayın
        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(box).perform();
        bekle(2);

        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        // Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }

}
