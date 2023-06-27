package practiceMix2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Action5 extends TestBase {
    @Test
    public void keyboardActions() {

        // Google a gidin https://www.google.com
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        bekle(2);

        // ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT).sendKeys("iPhone X fiyatlari").perform();
        bekle(2);

        // ‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK) Ve ENTER tusuna bas
        actions.keyUp(Keys.SHIFT).sendKeys(" cok pahali!", Keys.ENTER).perform();

    }
}

