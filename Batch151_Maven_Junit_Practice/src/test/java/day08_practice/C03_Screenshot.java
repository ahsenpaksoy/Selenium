package day08_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_Screenshot extends TestBase {
    @Test
    public void test01() throws IOException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");


       /*
           Bu Kod blogunu eger cookies cikarsa try-catch ile yakala ve tikla kapat dedik; Eger cikmazsa
        sout icindeki mesaji bize yazdirip gececek. !!!!!!!
        */

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }


        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("oppo", Keys.ENTER);

        // sonuc yazısını yazdiriniz
        WebElement sonucYaizisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println(sonucYaizisi.getText());

        // ilk urunun fotografını cekin
        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));

        File kayit = new File("target/ekranGoruntusu/urun.Jpeg");
        File geciciDosya = ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,kayit);

    }
}
