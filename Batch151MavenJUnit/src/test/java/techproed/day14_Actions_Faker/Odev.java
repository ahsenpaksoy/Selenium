package techproed.day14_Actions_Faker;

import org.junit.Test;
import techproed.utilities.TestBase;

public class Odev extends TestBase {

    @Test
    public void name() {
        /*
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over  Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin  8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
     */
    }
}

  /*
   @Test
    public void test01() throws InterruptedException {


//     1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

//     2- Hover over  Me First" kutusunun ustune gelin
       WebElement meFirst= driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(3);
        actions.moveToElement(meFirst).perform();
        bekle(3);

//     3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();
        bekle(3);

//     4- Popup mesajini yazdirin
        System.out.println("PopUp mesaji = " +driver.switchTo().alert().getText());

//     5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

//     6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.clickAndHold(clickAndHold).perform();

//     7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement yazi = driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']"));
        System.out.println("Yazi = " + yazi.getText());
        bekle(3);

//     8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin

       WebElement beforeDoubleClick = driver.findElement(By.xpath("//*[@class='div-double-click']"));
       actions.doubleClick(beforeDoubleClick).perform();

       WebElement afterDoubleClick = driver.findElement(By.xpath("//*[@class='div-double-click double']"));
       Assert.assertTrue(afterDoubleClick.isDisplayed());


    }
   */