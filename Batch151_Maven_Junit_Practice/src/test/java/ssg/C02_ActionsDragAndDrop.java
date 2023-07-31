package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {

    // http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html sayfasına gidiniz.
    // Baskentleri uygun ulke kutucuklarına surukleyip bırakınız.

    @Test
    public void test01() {

        // http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html sayfasına gidiniz.
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Baskentleri uygun ulke kutucuklarına surukleyip bırakınız.

        //BASKENT
        WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement stockholm = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement copenhagen = driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement seoul = driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement roma = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement madrid = driver.findElement(By.xpath("//div[@id='box7']"));

        // ULKE
        WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
        WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
        WebElement usa = driver.findElement(By.xpath("//div[@id='box103']"));
        WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
        WebElement sKorea = driver.findElement(By.xpath("//div[@id='box105']"));
        WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
        WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(oslo,norway).
                dragAndDrop(stockholm,sweden).
                dragAndDrop(washington,usa).
                dragAndDrop(copenhagen,denmark).
                dragAndDrop(seoul,sKorea).
                dragAndDrop(roma,italy).
                dragAndDrop(madrid,spain).
                perform();

    }
}
