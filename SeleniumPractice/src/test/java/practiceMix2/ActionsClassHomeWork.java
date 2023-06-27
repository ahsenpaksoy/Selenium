package practiceMix2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsClassHomeWork extends TestBase {
    @Test
    public void test01() {
        // "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        bekle(2);

        // Hover over Me First" kutusunun ustune gelin
        WebElement hoverOver = driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOver).perform();
        bekle(2);

        // Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        bekle(2);

        // Popup mesajini yazdirin
        String popUp = driver.switchTo().alert().getText();
        System.out.println(popUp);

        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(2);

        // “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButton = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldButton).perform();

        // “Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldButton.getText());

        // “Double click me" butonunu cift tiklayin
        WebElement doubleClickButton = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClickButton).perform();
    }
}
