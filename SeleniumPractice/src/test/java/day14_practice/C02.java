package day14_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02 extends TestBase {
    @Test
    public void test01() throws IOException {

        // -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        bekle(1);

        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

        // -Kutucuk içindeki rengi önce kırmızı oldugunda ekran goruntusu alalim

        WebElement birincitus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        WebElement ikincitus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement ucuncutus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(birincitus).moveByOffset(70, 0).release().perform();
        actions.clickAndHold(ikincitus).moveByOffset(-160, 0).release().perform();
        actions.clickAndHold(ucuncutus).moveByOffset(-70, 0).release().perform();

        String date = new SimpleDateFormat("_hh_mm_ss_").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/TakesScreenshot" + date + ".png"));

        bekle(2);

        // sonra sarı yapıldiktan sonra tekrar ekran goruntusu alalim
        actions.clickAndHold(ikincitus).moveByOffset(320, 0).release().perform();

        WebElement s1 = driver.findElement(By.xpath("//*[@class='ui-widget-content']"));

        String dosyaYolu = "src/test/java/TeamPackage/ScreenShot/ekrangoruntusu" + date + ".png";
        FileUtils.copyFile(s1.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        //-Sarı olduğunu test edelim
        Assert.assertTrue(s1.isDisplayed());


    }
}





