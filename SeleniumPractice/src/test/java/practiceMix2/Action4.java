package practiceMix2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Action4 extends TestBase {
    @Test
    public void dragAndDropTest() {

        // Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        bekle(2);

        // And user moves the target element(Drag me to my target) in to destination(Drop here)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        bekle(2);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = drag.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
    }

    @Test
    public void dragAndDropTest1() {
        // Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        bekle(2);

        // And user moves the target element(Drag me to my target) in to destination(Drop here)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        bekle(2);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = drag.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop).release().perform();

    }
}
